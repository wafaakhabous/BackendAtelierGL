package com.example.Users.controllers;

import com.example.Users.model.TravelCompanionRequest;
import com.example.Users.model.User;
import com.example.Users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")

@CrossOrigin(origins = "http://localhost:3000")

public class UserController
{
    @Autowired
    private UserService tripService;
    @GetMapping
    public List<User> getAllUsers() {
        return tripService.getAllUsers();
    }
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable long id) {
        return tripService.getUserById(id);
    }

    @PostMapping
    public User createTrip(@RequestBody User trip) {
        return tripService.createUser(trip);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateTrip(@PathVariable long id, @RequestBody User trip) throws IOException {
        if (tripService.getUserById(id).isPresent()) {
            trip.setId(id);
            return ResponseEntity.ok(tripService.createUser(trip));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/comp")
    public List<TravelCompanionRequest> getAllRequests() {
        return tripService.getAllRequests();
    }

    @PostMapping("/comp")
    public ResponseEntity<TravelCompanionRequest> createRequest(
            @RequestBody TravelCompanionRequest request) {
        TravelCompanionRequest createdRequest = tripService.createRequest(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        tripService.deleteUser(id);
    }
}

