package com.example.Users.service;

import com.example.Users.client.DataComp;
import com.example.Users.client.DataInv;
import com.example.Users.client.DataUser;
import com.example.Users.model.Invitation;
import com.example.Users.model.TravelCompanionRequest;
import com.example.Users.model.User;
import com.example.Users.repository.TravelCompanionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private DataUser client;
    @Autowired
    private DataComp clientt;
    @Autowired
    private DataInv clienttt;
    public List<User> getAllUsers() {
        return client.findAll();
    }

    public   Optional<User> getUserById(long id) {
        return client.findById(id);
    }

    public   Optional<TravelCompanionRequest> getTravelCompanionRequestById(long id) {
        return clientt.findById(id);
    }

    public   void deleteUser(long id) {
        client.deleteById(id);
    }

    public   User createUser(User User) {
        return client.save(User);
    }

    public User findByUsername(String username) {
        return client.findByUsername(username);
    }

    public User updtaeUser(User User) {
        return client.updateUser(User);
    }

    public List<TravelCompanionRequest> getAllRequests() {
        return clientt.findAll();
    }
    public TravelCompanionRequest createRequest(TravelCompanionRequest request)
    {
        return clientt.save(request);
    }


    public List<Invitation> getAllInvitations() {
        return clienttt.findAll();
    }
    public Invitation createInvitation(Invitation request)
    {
        return clienttt.save(request);
    }
    public List<Invitation> getInvitationsByReceiver(Long receiverId) {
        return clienttt.getInvitationsByReceiver(receiverId);
    }
}