package commonsense.tree.graph.dijkstra;

import java.util.*;

public class Dijkstra {
    public List<String> shortestPath(City startingCity, City finalDestination){
        Map<String,Integer> cheapestPriceTable = new HashMap<>();
        Map<String,String> cheapestPreviousStopoverCityTable = new HashMap<>();

        Map<City,Boolean> visitedCities = new HashMap<>();
        PriorityQueue<City> unvisitedCities = new PriorityQueue<>(
                Comparator.comparing(city -> cheapestPriceTable.getOrDefault(city.getName(), Integer.MAX_VALUE))
        );

        cheapestPriceTable.put(startingCity.getName(),0);
        City current = startingCity;

        while (current != null) {
            visitedCities.put(current,true);
            unvisitedCities.remove(current);

            for (Map.Entry<City,Integer> route : current.getRoutes().entrySet()) {
                final City adjacentCity = route.getKey();
                final Integer adjacentCityPrice = route.getValue();
                if (!visitedCities.containsKey(adjacentCity)) {
                    unvisitedCities.add(adjacentCity);
                }

                int priceThroughCurrentCity = cheapestPriceTable.get(current.getName()) + adjacentCityPrice; // TODO if current city is not found?

                if (!cheapestPriceTable.containsKey(adjacentCity.getName()) || priceThroughCurrentCity < cheapestPriceTable.get(adjacentCity.getName())) {
                    cheapestPriceTable.put(adjacentCity.getName(),priceThroughCurrentCity);
                    cheapestPreviousStopoverCityTable.put(adjacentCity.getName(), current.getName());
                }
            }
            // get next city with the cheapest price
            current = unvisitedCities.poll();
        }

        List<String> shortestPath = new ArrayList<>();
        String currentCityName = finalDestination.getName();

        while (!currentCityName.equalsIgnoreCase(startingCity.getName())) {
            shortestPath.add(currentCityName);
            currentCityName = cheapestPreviousStopoverCityTable.get(currentCityName);
        }
        shortestPath.add(startingCity.getName());

        return shortestPath.reversed();
    }

    public List<String> shortestPathSubOptimal(City startingCity, City finalDestination){
        Map<String,Integer> cheapestPriceTable = new HashMap<>();
        Map<String,String> cheapestPreviousStopoverCityTable = new HashMap<>();

        Map<City,Boolean> visitedCities = new HashMap<>();
        List<City> unvisitedCities = new ArrayList<>();

        cheapestPriceTable.put(startingCity.getName(),0);
        City current = startingCity;

        while (current != null) {
            visitedCities.put(current,true);
            unvisitedCities.remove(current);

            for (Map.Entry<City,Integer> route : current.getRoutes().entrySet()) {
                final City adjacentCity = route.getKey();
                final Integer adjacentCityPrice = route.getValue();
                if (!visitedCities.containsKey(adjacentCity)) {
                    unvisitedCities.add(adjacentCity);
                }

                int priceThroughCurrentCity = cheapestPriceTable.get(current.getName()) + adjacentCityPrice; // TODO if current city is not found?

                if (!cheapestPriceTable.containsKey(adjacentCity.getName()) || priceThroughCurrentCity < cheapestPriceTable.get(adjacentCity.getName())) {
                    cheapestPriceTable.put(adjacentCity.getName(),priceThroughCurrentCity);
                    cheapestPreviousStopoverCityTable.put(adjacentCity.getName(), current.getName());
                }
            }

            // could swap with priority queue
            City minCity = null;
            if (!unvisitedCities.isEmpty()) {
                minCity = unvisitedCities.getFirst();
                for (City unvisitedCity : unvisitedCities) {
                    if(cheapestPriceTable.get(unvisitedCity.getName()) < cheapestPriceTable.get(minCity.getName())) {
                        minCity = unvisitedCity;
                    }
                }
            }
            current = minCity;
        }

        List<String> shortestPath = new ArrayList<>();
        String currentCityName = finalDestination.getName();

        while (!currentCityName.equalsIgnoreCase(startingCity.getName())) {
            shortestPath.add(currentCityName);
            currentCityName = cheapestPreviousStopoverCityTable.get(currentCityName);
        }
        shortestPath.add(startingCity.getName());

        return shortestPath.reversed();
    }
}
