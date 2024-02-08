package com.example.Trips.controller;

import com.example.Trips.model.Trip;
import com.example.Trips.model.User;
import com.example.Trips.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/trips")
@CrossOrigin(origins = "http://localhost:3000")
public class TripController {

    @Autowired
    private TripService tripService;


    @GetMapping
    public List<Trip> getAllBlogs() {
        return tripService.getAllTrips();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTrip(@PathVariable long id) {
        return tripService.getTripById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public Trip createTrip(@RequestBody Trip trip) {
        System.out.println("TRIIIIIIIIIIIIIIIIIIP" + trip.getPublisher().getId());
        return tripService.createTrip(trip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable long id, @RequestBody Trip trip) {
        if (tripService.getTripById(id).isPresent()) {
            trip.setId(id);
            return ResponseEntity.ok(tripService.createTrip(trip));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable long id) {
        tripService.deleteTrip(id);
    }
}

