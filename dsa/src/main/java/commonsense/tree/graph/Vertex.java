package commonsense.tree.graph;

import java.util.*;

public class Vertex<T> {
    final int id = UUID.randomUUID().hashCode();
    T value;
    List<Vertex<T>> edges;

    public Vertex(T value) {
        this.value = value;
        this.edges = new ArrayList<>();
    }

    public void addAdjacentVertex(Vertex<T> adjacentVertex) {
        edges.add(adjacentVertex);
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
}
