package commonsense.tree.graph.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dijkstra {
    public List<String> shortestPath(City startCity, City endCity){
        Map<String,Integer> cheapestPriceTable = new HashMap<>();
        Map<String,String> cheapestPreviousStopoverCityTable = new HashMap<>();

        List<City> unvisitedCities = new ArrayList<>();
        Map<City,Boolean> visitedCities = new HashMap<>();


        cheapestPriceTable.put(startCity.getName(),0);
        City current = startCity;
        while (current != null) {

            visitedCities.put(current,true);
            unvisitedCities.remove(current);

            for ( Map.Entry<City,Integer> route : current.getRoutes().entrySet()) {
                final City adjacentCity = route.getKey();
                final Integer price = route.getValue();
                if (!visitedCities.containsKey(adjacentCity)) {
                    unvisitedCities.add(adjacentCity);
                }

                int priceThroughCurrentCity = cheapestPriceTable.get(current.getName()) + price;

                if (!cheapestPriceTable.containsKey(current.getName()) || priceThroughCurrentCity < cheapestPriceTable.get(adjacentCity.getName())) {
                    cheapestPriceTable.put(adjacentCity.getName(),priceThroughCurrentCity);
                    cheapestPreviousStopoverCityTable.put(adjacentCity.getName(), current.getName());
                }
            }
            City minCity = unvisitedCities.get(0);
            for (City unvisitedCity : unvisitedCities) {
                if(cheapestPriceTable.get(unvisitedCity.getName()) < cheapestPriceTable.get(minCity.getName())) {
                    minCity = unvisitedCity;
                }
            }
            current = minCity;

        }
        return null;
    }
}
