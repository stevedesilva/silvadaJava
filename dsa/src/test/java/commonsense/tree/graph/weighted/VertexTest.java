package commonsense.tree.graph.weighted;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VertexTest {
    @Test
    void addAdjacentVertex() {
        // create vertices
        Vertex<String> v1 = new Vertex<>("one");
        Vertex<String> v2 = new Vertex<>("two");
        Vertex<String> v3 = new Vertex<>("three");
        // add adjacent vertices
        v1.addAdjacentVertices(v2, 10);
        v1.addAdjacentVertices(v3, 20);
        // check if vertices are adjacent
        MatcherAssert.assertThat(v1.getVertexMap().get(v2), Matchers.is(10));
        MatcherAssert.assertThat(v1.getVertexMap().get(v3), Matchers.is(20));
    }

}