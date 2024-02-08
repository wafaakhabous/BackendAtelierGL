package com.MysqlService.MysqlService.controller;


import com.MysqlService.MysqlService.model.Invitation;
import com.MysqlService.MysqlService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inv")
public class InvitationController {
    private final UserService userService;
    @Autowired
    public InvitationController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/inv/All")
    public List<Invitation> getAllInvitations() {
        return userService.getAllInvitations();
    }
   @GetMapping("/inv/{receiverId}")
    List<Invitation> findByUserReceiverId(@PathVariable Long receiverId){
        return userService.findByUserReceiverId(receiverId);
    }



    @PostMapping("/inv/Add")
    public ResponseEntity<Invitation> createInvitation(@RequestBody Invitation request) {
        System.out.println("Received Invitation Payload: " + request.getUserSender());

        // Retrieve the user_receiver value from the request payload
        Long userReceiverId = request.getUserReceiver();

        // Set the user_receiver field in the Invitation object
        request.setUserReceiver(userReceiverId);

        // Now the Invitation object should have the user_receiver field properly set
        System.out.println("Received Invitation Payload: " + request.toString());

        // Proceed with saving the Invitation object
        Invitation createdInvitation = userService.createInvitation(request);
        System.out.println("Created Invitation: " + createdInvitation.toString());

        // Return the response
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvitation);
    }

}
