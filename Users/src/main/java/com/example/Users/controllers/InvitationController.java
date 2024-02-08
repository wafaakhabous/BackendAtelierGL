package com.example.Users.controllers;

import com.example.Users.model.Invitation;
import com.example.Users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inv")
@CrossOrigin(origins = "http://localhost:3000")

public class InvitationController {
    @Autowired
    private UserService tripService;
    @GetMapping("/inv")
    public List<Invitation> getAllInvitations() {
        return tripService.getAllInvitations();
    }
    @PostMapping("/inv")
    public ResponseEntity<Invitation> createRequest(@RequestBody Invitation request) {
        System.out.println("Received invitation Payload: " + request.toString());

        // Log the request body fields individually
        System.out.println("User Sender: " + request.getUserSender());
        System.out.println("User Receiver: " + request.getUserReceiver());
        // Add additional fields as needed

        Invitation createdRequest = tripService.createInvitation(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
    }
    @GetMapping("/inv/{receiverId}")
    public List<Invitation> getInvitationsByReceiver(@PathVariable Long receiverId) {
        return tripService.getInvitationsByReceiver(receiverId);
    }
}
