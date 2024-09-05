package com.shacky.maps_routes;

package com.example.routingservice.controller;

import com.example.routingservice.service.RoutingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;

class RoutingControllerTest {

    @InjectMocks
    private RoutingController routingController;

    @Mock
    private RoutingService routingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetRoute_validRoute() {
        // Mock the service to return a valid route
        List<String> route = Arrays.asList("CZE", "AUT", "ITA");
        when(routingService.calculateRoute("CZE", "ITA")).thenReturn(route);

        // Call the controller method
        ResponseEntity<?> response = routingController.getRoute("CZE", "ITA");

        // Check response status and body
        assertEquals(OK, response.getStatusCode());
        assertEquals(Collections.singletonMap("route", route), response.getBody());
    }

    @Test
    void testGetRoute_noRouteAvailable() {
        // Mock the service to return null when no route is available
        when(routingService.calculateRoute("CZE", "USA")).thenReturn(null);

        // Call the controller method
        ResponseEntity<?> response = routingController.getRoute("CZE", "USA");

        // Check response status and body
        assertEquals(BAD_REQUEST, response.getStatusCode());
        assertEquals("No land route available from CZE to USA", response.getBody());
    }

    @Test
    void testGetRoute_invalidCountryCode() {
        // Mock the service to throw an exception when invalid country codes are provided
        when(routingService.calculateRoute("XYZ", "ITA"))
                .thenThrow(new IllegalArgumentException("Invalid country code"));

        // Call the controller method
        ResponseEntity<?> response = routingController.getRoute("XYZ", "ITA");

        // Check response status and body
        assertEquals(BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid country code", response.getBody());
    }
}
