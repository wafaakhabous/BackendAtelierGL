package com.MysqlService.MysqlService.controller;


import com.MysqlService.MysqlService.model.Trip;
import com.MysqlService.MysqlService.model.User;
import com.MysqlService.MysqlService.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/vi/trips")
public class TripController {
    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/Add")
    public Trip saveTrip(@RequestBody Trip trip) {
        System.out.println("TRIIIIIIIIIIIIIIIIIIP" + trip.getPublisher().getId());
        return tripService.saveTrip(trip);
    }


    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id) {
        tripService.deleteById(id);
    }

    @GetMapping("/{id}")
    Optional<Trip> findById(@PathVariable("id") long id) {
        return tripService.findById(id);
    }

    @GetMapping("/All")
    List<Trip> findAll() {
        return tripService.findAll();
    }
}
