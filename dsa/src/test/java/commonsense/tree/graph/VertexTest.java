package commonsense.tree.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VertexTest {

    @Test
    void addAdjacentVertex() {
        // create vertices
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);

        // add adjacent vertices
        v1.addAdjacentVertex(v2);
        v2.addAdjacentVertex(v1);

        // check if vertices are adjacent
        assertTrue(v1.edges.contains(v2));
        assertTrue(v2.edges.contains(v1));
    }

    @Test
    void dfsTraverse() {
        // create vertices
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);

        // add adjacent vertices
        v1.addAdjacentVertex(v2);
        v1.addAdjacentVertex(v3);
        v2.addAdjacentVertex(v4);
        v3.addAdjacentVertex(v4);
        v4.addAdjacentVertex(v5);

        // traverse the graph
        v1.dfsTraverse();
    }
}