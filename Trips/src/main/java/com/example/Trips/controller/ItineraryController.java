package com.example.Trips.controller;

import com.example.Trips.model.Itinerary;
import com.example.Trips.service.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itinerary")
public class ItineraryController {
    private final ItineraryService Service;

    @Autowired
    public ItineraryController(ItineraryService ItineraryService)
    {
        this.Service = ItineraryService;
    }

    @GetMapping
    public List<Itinerary> getAllItinerarys() {
        return Service.getAllItinerary();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Itinerary> getItineraryById(@PathVariable long id) {
        return Service.getItineraryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Itinerary createItinerary(@RequestBody Itinerary itinerary) {

        return Service.saveItinerary(itinerary);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Itinerary> updateItinerary(@PathVariable long id, @RequestBody Itinerary itinerary) {
        if (Service.getItineraryById(id).isPresent()) {
            itinerary.setId(id);
            return ResponseEntity.ok(Service.saveItinerary(itinerary));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItinerary(@PathVariable long id) {
        /**
        if (Service.getItineraryById(id).isPresent()) {
            Service.deleteItinerary(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
        **/
        Service.deleteItinerary(id);
        return ResponseEntity.ok().build();
    }
}
