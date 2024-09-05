package com.shacky.maps_routes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoutingServiceTest {

    @InjectMocks
    private RoutingService routingService;

    @Mock
    private Map<String, Country> countryMap;

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

        // Mock the country map
        countryMap = new HashMap<>();
        countryMap.put("CZE", cze);
        countryMap.put("AUT", aut);
        countryMap.put("ITA", ita);

        // Inject the mock country map into the service
        routingService.countryMap = countryMap;
    }

    @Test
    void testCalculateRoute_validRoute() {
        List<String> route = routingService.calculateRoute("CZE", "ITA");

        // Check if the expected route is returned
        assertNotNull(route);
        assertEquals(Arrays.asList("CZE",
