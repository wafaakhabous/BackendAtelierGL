package com.MysqlService.MysqlService.service;

import com.MysqlService.MysqlService.model.Itinerary;
import com.MysqlService.MysqlService.repository.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItineraryService {
    private final ItineraryRepository itineraryRepository;

    @Autowired
    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    public Itinerary save(Itinerary itinerary) {
        return itineraryRepository.save(itinerary);
    }

    public void deleteById(long id) {
        itineraryRepository.deleteById(id);
    }

    public Optional<Itinerary> findById(long id) {
        return itineraryRepository.findById(id);
    }

    public List<Itinerary> findAll() {
        return itineraryRepository.findAll();
    }
}
