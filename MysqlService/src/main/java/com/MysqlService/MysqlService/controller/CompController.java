package com.MysqlService.MysqlService.controller;


import com.MysqlService.MysqlService.model.TravelCompanionRequest;
import com.MysqlService.MysqlService.model.User;
import com.MysqlService.MysqlService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comp")
public class CompController {
    private final UserService userService;
    @Autowired
    public CompController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/compagnon/All")
    public List<TravelCompanionRequest> getAllRequests() {
        return userService.getAllRequests();
    }

    @PostMapping("/compagnon/Add")
    public ResponseEntity<TravelCompanionRequest> createRequest(@RequestBody TravelCompanionRequest request) {
        System.out.println("Received Request Payload: " + request.toString());
        Long userId = request.getUserId();
        request.setUserId(userId);
        System.out.println("userrrrrrrrrrr"+userId);
        TravelCompanionRequest createdRequest = userService.createRequest(request);
        System.out.println("Created Request: " + createdRequest.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
    }
    @GetMapping("/compagnon/{id}")
    public Optional<TravelCompanionRequest> findById(@PathVariable("id") Long id) {
        return userService.findByIdC(id);
    }
}
