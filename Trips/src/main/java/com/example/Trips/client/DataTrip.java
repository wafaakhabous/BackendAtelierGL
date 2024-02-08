package com.example.Trips.client;

import com.example.Trips.model.Trip;
import com.example.Trips.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Data-service-TRIP",  url = "${application.config.DataTRIP-url}")
public interface DataTrip {
    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id);

    @PostMapping("/Add")
    Trip save(@RequestBody Trip trip);

    @GetMapping("/{id}")
    Optional<Trip> findById(@PathVariable("id") long id);

    @GetMapping("/All")
    List<Trip> findAll();
}
