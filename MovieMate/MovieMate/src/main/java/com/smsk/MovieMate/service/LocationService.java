package com.smsk.MovieMate.service;

import com.smsk.MovieMate.model.Location;
import com.smsk.MovieMate.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Optional<Location> getLocationByName(String name) {
        return locationRepository.findByName(name);
    }

    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }
}
