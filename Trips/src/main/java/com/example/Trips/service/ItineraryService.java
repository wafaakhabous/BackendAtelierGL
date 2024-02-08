package com.example.Trips.service;

import com.example.Trips.client.DataItinerary;
import com.example.Trips.model.Itinerary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItineraryService {
    private DataItinerary client;

    public List<Itinerary> getAllItinerary() {
        return client.findAll();
    }

    public Optional<Itinerary> getItineraryById(long id) {
        return client.findById(id);
    }

    public Itinerary saveItinerary(Itinerary itinerary) {
        return client.save(itinerary);
    }

    public void deleteItinerary(long id) {
        client.deleteById(id);
    }

}
