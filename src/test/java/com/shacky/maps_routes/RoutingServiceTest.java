package com.shacky.maps_routes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoutingServiceTest {
    @Autowired
    private RoutingService routingService;

    @Test
    void testCalculateRoute_validRoute() {
        List<String> route = routingService.calculateRoute("CZE", "ITA");

        // Check if the expected route is returned
        assertNotNull(route);
        assertEquals(Arrays.asList("CZE", "AUT", "ITA"), route);
    }

    @Test
    void testCalculateRoute_validRoute2() {
        List<String> route = routingService.calculateRoute("POL", "CHE");

        // Check if the expected route is returned
        assertNotNull(route);
        assertEquals(Arrays.asList("POL", "DEU", "CHE"), route);
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
