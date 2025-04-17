package com.smsk.MovieMate.controller;

import  com.smsk.MovieMate.model.Location;
import com.smsk.MovieMate.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        return ResponseEntity.ok(locationService.getAllLocations());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Location> getLocationByName(@PathVariable String name) {
        Optional<Location> location = locationService.getLocationByName(name);
        return location.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addLocation(@RequestBody Location location) {
        try {
            Location savedLocation = locationService.addLocation(location);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedLocation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
