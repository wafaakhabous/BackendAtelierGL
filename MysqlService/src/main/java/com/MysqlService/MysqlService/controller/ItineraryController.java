package com.MysqlService.MysqlService.controller;


import com.MysqlService.MysqlService.model.Itinerary;
import com.MysqlService.MysqlService.service.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vi/itinerarys")
public class ItineraryController {
    private final ItineraryService itineraryService;

    @Autowired
    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id) {
        itineraryService.deleteById(id);
    }

    @PostMapping("/Add")
    Itinerary save(@RequestBody Itinerary itinerary) {
        return itineraryService.save(itinerary);
    }

    @GetMapping("/{id}")
    Optional<Itinerary> findById(@PathVariable("id") long id) {
        return itineraryService.findById(id);
    }

    @GetMapping("/All")
    List<Itinerary> findAll() {
        return itineraryService.findAll();
    }
}
