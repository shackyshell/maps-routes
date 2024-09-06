package com.shacky.maps_routes;

import com.shacky.maps_routes.Country;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

//import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.*;

@Service
public class RoutingService {

    private static final String DATA_URL = "https://raw.githubusercontent.com/mledoze/countries/master/countries.json";
    private Map<String, Country> countryMap;

//    @PostConstruct
    public void loadCountryData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Country> countries = objectMapper.readValue(new URL(DATA_URL), new TypeReference<List<Country>>() {});
        countryMap = new HashMap<>();

        for (Country country : countries) {
            countryMap.put(country.getCca3(), country);
        }
    }

    public void setCountryMap(Map<String, Country> countryMap) {
        this.countryMap = countryMap;
    }

    public Map<String, Country> getCountryMap() {
        return countryMap;
    }

    public List<String> calculateRoute(String origin, String destination) {
        if (!countryMap.containsKey(origin) || !countryMap.containsKey(destination)) {
            throw new IllegalArgumentException("Invalid country code");
        }

        return findShortestRoute(origin, destination);
    }

    private List<String> findShortestRoute(String origin, String destination) {
        Set<String> visited = new HashSet<>();
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(Collections.singletonList(origin));

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String lastCountry = path.get(path.size() - 1);

            if (lastCountry.equals(destination)) {
                return path;
            }

            Country country = countryMap.get(lastCountry);
            if (country == null || country.getBorders() == null) {
                continue;
            }

            for (String neighbor : country.getBorders()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.add(newPath);
                }
            }
        }

        return null; // No route found
    }
}
