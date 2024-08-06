package commonsense.tree.graph.shortestpath.unweighted;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VertexTest {

    @Test
    void shortestPath() {
    }

    @Test
    public void testShortestPath() {

        // create vertices
        Vertex<String> idris = new Vertex<>("idris");
        Vertex<String> kamil = new Vertex<>("kamil");
        Vertex<String> lina = new Vertex<>("lina");
        Vertex<String> sasha = new Vertex<>("sasha");
        Vertex<String> marco = new Vertex<>("marco");
        Vertex<String> ken = new Vertex<>("ken");
        Vertex<String> talia = new Vertex<>("talia");

        // add adjacent vertices
        idris.addAdjacentVertex(kamil);
        idris.addAdjacentVertex(talia);

        kamil.addAdjacentVertex(idris);
        kamil.addAdjacentVertex(lina);

        lina.addAdjacentVertex(kamil);
        lina.addAdjacentVertex(sasha);

        sasha.addAdjacentVertex(lina);
        sasha.addAdjacentVertex(marco);

        marco.addAdjacentVertex(sasha);
        marco.addAdjacentVertex(ken);

        ken.addAdjacentVertex(marco);
        ken.addAdjacentVertex(talia);

        talia.addAdjacentVertex(ken);
        talia.addAdjacentVertex(idris);


        // given a graph
        Vertex<String> graph = new Vertex<>();

        // when we find the shortest path
        graph.shortestPath(idris, lina);
        // then we should get the shortest path
        List<String> expected = List.of("idris", "kamil", "lina");
        MatcherAssert.assertThat(graph.shortestPath(idris, lina), Matchers.equalTo(expected));
    }

    @Test
    public void testShortestPathIdris() {

        // create vertices
        Vertex<String> idris = new Vertex<>("idris");
        Vertex<String> kamil = new Vertex<>("kamil");
        Vertex<String> lina = new Vertex<>("lina");
        Vertex<String> sasha = new Vertex<>("sasha");
        Vertex<String> marco = new Vertex<>("marco");
        Vertex<String> ken = new Vertex<>("ken");
        Vertex<String> talia = new Vertex<>("talia");

        // add adjacent vertices
        idris.addAdjacentVertex(kamil);
        idris.addAdjacentVertex(talia);
        idris.addAdjacentVertex(lina);

        kamil.addAdjacentVertex(idris);
        kamil.addAdjacentVertex(lina);

        lina.addAdjacentVertex(kamil);
        lina.addAdjacentVertex(sasha);

        sasha.addAdjacentVertex(lina);
        sasha.addAdjacentVertex(marco);

        marco.addAdjacentVertex(sasha);
        marco.addAdjacentVertex(ken);

        ken.addAdjacentVertex(marco);
        ken.addAdjacentVertex(talia);

        talia.addAdjacentVertex(ken);
        talia.addAdjacentVertex(idris);


        // given a graph
        Vertex<String> graph = new Vertex<>();

        // when we find the shortest path
        graph.shortestPath(idris, lina);
        // then we should get the shortest path
        List<String> expected = List.of("idris", "lina");
        MatcherAssert.assertThat(graph.shortestPath(idris, lina), Matchers.equalTo(expected));
    }

}