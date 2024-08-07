package commonsense.tree.graph.shortestpath.unweighted;

import java.util.*;

public class Vertex<T> {
    final int id = UUID.randomUUID().hashCode();
    T value;
    List<Vertex<T>> edges;

    public Vertex() {
    }

    public Vertex(T value) {
        this.value = value;
        this.edges = new ArrayList<>();
    }

    public void addAdjacentVertex(Vertex<T> vertex) {
        if (edges.contains(vertex)) {
            return;
        }
        edges.add(vertex);
        vertex.addAdjacentVertex(this);
    }

    public Vertex<T> dfs(T value) {
        return dfs(value, this, new HashMap<Vertex<T>, Boolean>());
    }

    private Vertex<T> dfs(T value, Vertex<T> vertex, Map<Vertex<T>, Boolean> visited) {
        // return if
        if (vertex.value.equals(value)) {
            return vertex;
        }
        visited.put(vertex, true);

        for (Vertex<T> adjacentVertx : vertex.edges) {
            if (!visited.containsKey(adjacentVertx)) {
                if (adjacentVertx.value.equals(value)) {
                    return adjacentVertx;
                }
                Vertex<T> result = dfs(value, adjacentVertx, visited);
                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }

    // dfs_traversal
    public void dfsTraverse() {
        // create a map to store visited vertex
        Map<Vertex<T>, Boolean> visited = new HashMap<>();

        // call dfsTraverse recursively
        dfsTraverse(this, visited);
    }

    private void dfsTraverse(Vertex<T> vertex, Map<Vertex<T>, Boolean> visited) {
        // if vertex is already visited mark it as true
        visited.put(vertex, true);

        // print the vertex
        System.out.println(vertex.value);

        // for each adjacent vertex of the vertex
        for (Vertex<T> adjacent : vertex.edges) {
            // if adjacent vertex is already visited
            if (!visited.containsKey(adjacent)) {
                // call dfsTraverse recursively
                dfsTraverse(adjacent, visited);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return id == vertex.id && Objects.equals(value, vertex.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    public void breathFirstSearchTraverse() {
        // create a map to store visited vertex
        Map<Vertex<T>, Boolean> visited = new HashMap<>();
        // java queue
        Queue<Vertex<T>> queue = new LinkedList<>();

        // call dfsTraverse recursively
        bfsTraverse(this, visited, queue);
    }

    private void bfsTraverse(Vertex<T> vertex, Map<Vertex<T>, Boolean> visited, Queue<Vertex<T>> queue) {
        visited.put(vertex, true);
        queue.add(vertex);
        while (!queue.isEmpty()) {
            final Vertex<T> current = queue.remove();
            System.out.println(current.value);
            for (Vertex<T> v : current.edges) {
                if (!visited.containsKey(v)) {
                    visited.put(v, true);
                    queue.add(v);
                }
            }
        }
    }

    public Vertex<T> breathFirstSearch(T value) {
        Map<Vertex<T>, Boolean> visited = new HashMap<>();
        Queue<Vertex<T>> queue = new LinkedList<>();
        visited.put(this, true);
        queue.add(this);
        while (!queue.isEmpty()) {
            final Vertex<T> current = queue.remove();
            if (current.value.equals(value)) {
                return current;
            }
            for (Vertex<T> v : current.edges) {
                if (!visited.containsKey(v)) {
                    visited.put(v, true);
                    queue.add(v);
                }
            }
        }
        return null;
    }

    public List<T> shortestPath(Vertex<T> start, Vertex<T> end) {
        // visited nodes
        Set<Vertex<T>> visitedVertices = new HashSet<>();
        visitedVertices.add(start);
        // queue
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(start);

        Map<Vertex<T>, Vertex<T>> previousVertex = new HashMap<>();
        // while queue is not empty
        while (!queue.isEmpty()) {
            Vertex<T> currentVertex = queue.remove();
            for (Vertex<T> adjacentVertx : currentVertex.edges) {
                if (!visitedVertices.contains(adjacentVertx)) {
                    visitedVertices.add(adjacentVertx);
                    queue.add(adjacentVertx);

                    previousVertex.put(adjacentVertx, currentVertex);
                }
            }
        }

        List<T> shortestPath = new ArrayList<>();
        Vertex<T> current = end;
        while (current != start) {
            shortestPath.add(current.value);
            current = previousVertex.get(current);
        }
        shortestPath.add(start.value);
        return shortestPath.reversed();
    }
}
