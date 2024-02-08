package com.example.Trips.service;

import com.example.Trips.client.DataTrip;
import com.example.Trips.model.Trip;
import com.example.Trips.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private DataTrip client;

    public List<Trip> getAllTrips() {
        return client.findAll();
    }

    public Optional<Trip> getTripById(long id) {
        return client.findById(id);
    }


    public void deleteTrip(long id) {
        client.deleteById(id);
    }

    public Trip createTrip(Trip trip) {
        System.out.println("TRIIIIIIIIIIIIIIIIIIP" + trip.getPublisher().getId());
        return client.save(trip);
    }


}
