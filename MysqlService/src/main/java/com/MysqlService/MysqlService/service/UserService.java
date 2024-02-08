package com.MysqlService.MysqlService.service;
import com.MysqlService.MysqlService.model.Invitation;
import com.MysqlService.MysqlService.model.TravelCompanionRequest;
import com.MysqlService.MysqlService.model.User;
import com.MysqlService.MysqlService.repository.InvitationRepository;
import com.MysqlService.MysqlService.repository.TravelCompanionRequestRepository;
import com.MysqlService.MysqlService.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    private final UserRepository userRepository;
    private final InvitationRepository invRepository;
    private final TravelCompanionRequestRepository requestRepository;

    public UserService(UserRepository userRepository, TravelCompanionRequestRepository requestRepository,InvitationRepository invRepository) {
        this.userRepository = userRepository;
        this.requestRepository = requestRepository;
        this.invRepository=invRepository;
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll(); // Assuming you have a findAllUsers method in your client
    }
    public User saveUser(User trip) {
        return userRepository.save(trip);
    }
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    public Optional<TravelCompanionRequest> findByIdC(Long id) {
        return requestRepository.findById(id);
    }

    public User updateUser(User updatedUser) {
        return userRepository.findById(updatedUser.getId())
                .map(existingUser -> {
                    existingUser.setFirstname(updatedUser.getFirstname());
                    existingUser.setLastname(updatedUser.getLastname());
                    existingUser.setUsername(updatedUser.getUsername());
                    existingUser.setPassword(updatedUser.getPassword());
                    return userRepository.save(existingUser);
                })
                .orElse(null);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public List<TravelCompanionRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    public TravelCompanionRequest createRequest(TravelCompanionRequest request) {
        return requestRepository.save(request);
    }
    public List<Invitation> getAllInvitations()
    {
        return invRepository.findAll();
    }
    public List<Invitation> findByUserReceiverId(Long userReceiver)
    {
        return invRepository.findByUserReceiver(userReceiver);
    }
    public Invitation createInvitation(Invitation request) {
        return invRepository.save(request);
    }
}
