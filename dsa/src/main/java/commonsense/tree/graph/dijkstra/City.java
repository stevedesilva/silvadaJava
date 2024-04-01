package commonsense.tree.graph.dijkstra;

import java.util.HashMap;
import java.util.Map;

public class City {
    final private String name;
    private Map<City,Integer> routes = new HashMap<>();

    public City(String name) {
        this.name = name;
        this.routes = new HashMap<>();
    }

    public void addRoutes(City city, Integer price) {
        routes.put(city,price);
    }

    public String getName() {
        return name;
    }

    public Map<City, Integer> getRoutes() {
        return routes;
    }


}
