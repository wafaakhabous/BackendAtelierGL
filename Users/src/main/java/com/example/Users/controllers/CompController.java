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
@RequestMapping("/comp")

@CrossOrigin(origins = "http://localhost:3000")

public class CompController
{
    @Autowired
    private UserService tripService;

    @GetMapping("/comp")
    public List<TravelCompanionRequest> getAllRequests() {
        return tripService.getAllRequests();
    }
    @PostMapping("/comp")
    public ResponseEntity<TravelCompanionRequest> createRequest(@RequestBody TravelCompanionRequest request) {
        System.out.println("Received Request Payload: " + request.toString());

        TravelCompanionRequest createdRequest = tripService.createRequest(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
    }
    @GetMapping("/{id}")
    public Optional<TravelCompanionRequest> getRequest(@PathVariable long id) {
        return tripService.getTravelCompanionRequestById(id);
    }

}