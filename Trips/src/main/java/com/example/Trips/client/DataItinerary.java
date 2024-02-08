package com.example.Trips.client;

import com.example.Trips.model.Itinerary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Data-service-ITEN",  url = "${application.config.DataITIN-url}")

public interface DataItinerary {
    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id);

    @PostMapping("/Add")
    Itinerary save(@RequestBody Itinerary itinerary);

    @GetMapping("/{id}")
    Optional<Itinerary> findById(@PathVariable("id") long id);

    @GetMapping("/All")
    List<Itinerary> findAll();
}
