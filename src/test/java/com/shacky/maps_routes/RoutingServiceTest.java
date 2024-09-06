package com.shacky.maps_routes;

import com.shacky.maps_routes.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RoutingServiceTest {

    @InjectMocks
    private RoutingService routingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create mock countries
        Country cze = new Country();
        cze.setCca3("CZE");
        cze.setBorders(Arrays.asList("AUT", "DEU"));

        Country aut = new Country();
        aut.setCca3("AUT");
        aut.setBorders(Arrays.asList("CZE", "ITA"));

        Country ita = new Country();
        ita.setCca3("ITA");
        ita.setBorders(Arrays.asList("AUT"));

        Country usa = new Country();
        usa.setCca3("USA");
        usa.setBorders(Arrays.asList());

        // Mock the country map
        Map<String, Country> countryMap = new HashMap<>();
        countryMap.put("CZE", cze);
        countryMap.put("AUT", aut);
        countryMap.put("ITA", ita);
        countryMap.put("USA", usa);

        // Inject the mock country map into the service
        routingService.setCountryMap(countryMap);
    }

    @Test
    void testCalculateRoute_validRoute() {
        List<String> route = routingService.calculateRoute("CZE", "ITA");

        // Check if the expected route is returned
        assertNotNull(route);
        assertEquals(Arrays.asList("CZE", "AUT", "ITA"), route);
    }

    @Test
    void testCalculateRoute_noRouteAvailable() {
        Country usa = new Country();
        usa.setCca3("USA");
        usa.setBorders(Arrays.asList());

        List<String> route = routingService.calculateRoute("CZE", "USA");

        assertNull(route, "No land route should be found between CZE and USA");
    }

    @Test
    void testCalculateRoute_invalidOrigin() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                routingService.calculateRoute("XYZ", "ITA"));

        assertEquals("Invalid country code", exception.getMessage());
    }

    @Test
    void testCalculateRoute_invalidDestination() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                routingService.calculateRoute("CZE", "XYZ"));

        assertEquals("Invalid country code", exception.getMessage());
    }
}
