package com.journeygenius.location_microservice.controller;

import com.journeygenius.location_microservice.data.Location;
import com.journeygenius.location_microservice.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping(path = "/locations")
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @PostMapping(path = "/locations")
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        return ResponseEntity.ok(locationService.saveLocation(location));
    }

//    @GetMapping(path = "/distance")
//    public ResponseEntity<Double> getDistance(@RequestParam String locationA, @RequestParam String locationB) {
//        double distance = locationService.calculateDistance(locationA, locationB);
//        return ResponseEntity.ok(distance);
//    }

    @GetMapping(path = "/location-information")
    public String getLocationDetails(@RequestParam String query){
        String locationDetails = locationService.getLocationDetails(query);
        return locationDetails;
    }
    // Additional endpoints can be added as needed
}
