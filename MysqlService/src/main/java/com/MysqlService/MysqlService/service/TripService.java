package com.MysqlService.MysqlService.service;

import com.MysqlService.MysqlService.model.Trip;
import com.MysqlService.MysqlService.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    private final TripRepository tripRepository;


    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip saveTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public void deleteById(long id) {
        tripRepository.deleteById(id);
    }

    public Optional<Trip> findById(long id) {
        return tripRepository.findById(id);
    }

    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

}
