package commonsense.tree.graph.weighted;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Vertex<T> {
    final int id = UUID.randomUUID().hashCode();
    private T value;
    private Map<Vertex<T>,Integer> vertexMap;


    public Vertex(T value) {
        this.value = value;
        this.vertexMap = new HashMap<>();
    }

    public void addAdjacentVertices(Vertex<T> vertex, Integer weight) {
        vertexMap.put(vertex,weight);
    }

    public int getId() {
        return id;
    }

    public T getValue() {
        return value;
    }

    public Map<Vertex<T>, Integer> getVertexMap() {
        return vertexMap;
    }
}
