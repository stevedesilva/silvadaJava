package commonsense.tree.graph;

import java.util.List;

public class Vertex<T> {
    T value;
    List<Vertex<T>> edges;

    public Vertex(T value, List<Vertex<T>> edges) {
        this.value = value;
        this.edges = edges;
    }

    public void addAdjacentVertex(Vertex<T> adjacentVertex) {
        edges.add(adjacentVertex);
    }
}
