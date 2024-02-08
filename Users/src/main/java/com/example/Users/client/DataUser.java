package com.example.Users.client;

import com.example.Users.model.TravelCompanionRequest;
import com.example.Users.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Data-service-users",  url = "${application.config.Datas-url}")
public interface DataUser {

    @DeleteMapping("/user/delete/{id}")
    void deleteById(@PathVariable("id") long id);

    @PostMapping("/user/Add")
    User save(@RequestBody User user);

    @GetMapping("/user/{id}")
    Optional<User> findById(@PathVariable("id") long id);

    @GetMapping("/user/All")
    List<User> findAll();

    @PostMapping("/user/username/{username}")
    User findByUsername(@PathVariable("username") String username);
    @DeleteMapping("/user/delete/{id}")
    void deleteUser(@PathVariable("id") long id);
    @PutMapping("/user/update")
    User updateUser(User updatedUser);

    @DeleteMapping("/compagnon/delete/{id}")
    void deleteByIdC(@PathVariable("id") long id);

    @PostMapping("/compagnon/Add")
    TravelCompanionRequest save(@RequestBody TravelCompanionRequest user);

    @GetMapping("/compagnon/{id}")
    Optional<TravelCompanionRequest> findByIdC(@PathVariable("id") long id);

    @GetMapping("/compagnon/All")
    List<TravelCompanionRequest> findAllC();
    @DeleteMapping("/compagnon/delete/{id}")
    void deleteCompagno(@PathVariable("id") long id);

    @PutMapping("/compagnon/update")
    TravelCompanionRequest updateCompagnon(TravelCompanionRequest updatedCompagnon);
}
