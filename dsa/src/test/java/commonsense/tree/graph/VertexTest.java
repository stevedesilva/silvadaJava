package commonsense.tree.graph;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
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

    @Test
    void dfs() {
        // create vertices
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);
        Vertex<Integer> v7 = new Vertex<>(7);
        Vertex<Integer> v8 = new Vertex<>(8);
        Vertex<Integer> v9 = new Vertex<>(9);

        // add adjacent vertices
        v1.addAdjacentVertex(v2);
        v1.addAdjacentVertex(v3);
        v1.addAdjacentVertex(v4);
        v1.addAdjacentVertex(v5);

        v2.addAdjacentVertex(v6);
        v6.addAdjacentVertex(v8);
        v8.addAdjacentVertex(v3);

        v3.addAdjacentVertex(v8);


        v4.addAdjacentVertex(v7);
        v7.addAdjacentVertex(v9);

        v5.addAdjacentVertex(v4);

        MatcherAssert.assertThat(v1.dfs(1), Matchers.equalTo(v1));
        MatcherAssert.assertThat(v2.dfs(1), Matchers.equalTo(v1));
        MatcherAssert.assertThat(v3.dfs(1), Matchers.equalTo(v1));
        MatcherAssert.assertThat(v4.dfs(1), Matchers.equalTo(v1));
        MatcherAssert.assertThat(v5.dfs(1), Matchers.equalTo(v1));

        MatcherAssert.assertThat(v1.dfs(2), Matchers.equalTo(v2));
        MatcherAssert.assertThat(v2.dfs(2), Matchers.equalTo(v2));
        MatcherAssert.assertThat(v3.dfs(2), Matchers.equalTo(v2));
        MatcherAssert.assertThat(v4.dfs(2), Matchers.equalTo(v2));
        MatcherAssert.assertThat(v5.dfs(2), Matchers.equalTo(v2));


        MatcherAssert.assertThat(v1.dfs(3), Matchers.equalTo(v3));
        MatcherAssert.assertThat(v1.dfs(4), Matchers.equalTo(v4));
        MatcherAssert.assertThat(v1.dfs(5), Matchers.equalTo(v5));
    }

}