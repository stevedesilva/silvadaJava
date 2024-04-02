package commonsense.tree.graph.dijkstra;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void shortestPath() {
    }

    @Test
    void testShortestPath() {

        City atlanta = new City("Atlanta");
        City boston = new City("Boston");
        City chicago = new City("Chicago");
        City denver = new City("Denver");
        City elPaso = new City("El Paso");

        atlanta.addRoutes(boston,100);
        atlanta.addRoutes(denver,160);

        boston.addRoutes(chicago,120);
        boston.addRoutes(denver,180);

        chicago.addRoutes(elPaso,80);

        denver.addRoutes(chicago,40);
        denver.addRoutes(elPaso,140);

        elPaso.addRoutes(boston,100);

        Dijkstra dijkstra = new Dijkstra();
        final List<String> result = dijkstra.shortestPath(atlanta, elPaso);
        final List<String> expected = List.of("Atlanta","Denver","Chicago","El Paso");

        MatcherAssert.assertThat(result,Matchers.equalTo(expected));
    }


    @ParameterizedTest
    @MethodSource("provideCitiesAndExpectedPaths")
    void testShortestPath(City source, City destination, List<String> expectedPath) {
        Dijkstra dijkstra = new Dijkstra();
        final List<String> result = dijkstra.shortestPath(source, destination);
        assertEquals(expectedPath, result);
    }

    private static Stream<Object[]> provideCitiesAndExpectedPaths() {
        City atlanta = new City("Atlanta");
        City boston = new City("Boston");
        City chicago = new City("Chicago");
        City denver = new City("Denver");
        City elPaso = new City("El Paso");

        atlanta.addRoutes(boston, 100);
        atlanta.addRoutes(denver, 160);
        boston.addRoutes(chicago, 120);
        boston.addRoutes(denver, 180);
        chicago.addRoutes(elPaso, 80);
        denver.addRoutes(chicago, 40);
        denver.addRoutes(elPaso, 140);
        elPaso.addRoutes(boston, 100);

        return Stream.of(
                new Object[]{atlanta, elPaso, List.of("Atlanta", "Denver", "Chicago", "El Paso")},
                new Object[]{atlanta, chicago, List.of("Atlanta", "Denver", "Chicago")},
                new Object[]{atlanta, boston, List.of("Atlanta", "Boston")},
                new Object[]{denver, elPaso, List.of("Denver", "Chicago", "El Paso")}
        );
    }


}