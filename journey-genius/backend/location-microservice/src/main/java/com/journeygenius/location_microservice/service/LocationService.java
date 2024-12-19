package com.journeygenius.location_microservice.service;

import com.journeygenius.location_microservice.data.Location;
import com.journeygenius.location_microservice.data.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    private final String SEARCH_API_URL = "https://us1.locationiq.com/v1/search?";
    private final String DISTANCE_MATRIX_API_URL = "https://us1.locationiq.com/v1/directions/driving/";
    private final String API_KEY = "pk.eaeb7461e0e73e6e0ef1e22d4255b1de";

        public String getLocationDetails(String query) {
        RestTemplate restTemplate = new RestTemplate();

        String url = String.format("%skey=%s&q=%s&format=JSON", SEARCH_API_URL, API_KEY, query);
        return restTemplate.getForObject(url, String.class);
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }


}
