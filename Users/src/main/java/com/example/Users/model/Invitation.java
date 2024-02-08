package com.example.Users.model;

import jakarta.persistence.*;
@Entity
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_sender")
    private Long userSender;

    @Column(name = "user_receiver")
    private Long userReceiver;
    @Column(name = "request_id") // Add a field for the request ID
    private Long requestId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Long getUserSender() {
        return userSender;
    }

    public void setUserSender(Long userSender) {
        this.userSender = userSender;
    }

    public Long getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(Long userReceiver) {
        this.userReceiver = userReceiver;
    }
// Constructors, getters, and setters
}