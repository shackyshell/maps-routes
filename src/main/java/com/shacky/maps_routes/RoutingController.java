package com.shacky.maps_routes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/routing")
public class RoutingController {
    private final RoutingService routingService;

    public RoutingController(RoutingService routingService) {
        this.routingService = routingService;
    }

    @GetMapping("/{origin}/{destination}")
    public ResponseEntity<?> getRoute(@PathVariable String origin, @PathVariable String destination) {
        try {
            List<String> route = routingService.calculateRoute(origin, destination);
            if (route == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("No land route available from " + origin + " to " + destination);
            }
            return ResponseEntity.ok(Collections.singletonMap("route", route));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
