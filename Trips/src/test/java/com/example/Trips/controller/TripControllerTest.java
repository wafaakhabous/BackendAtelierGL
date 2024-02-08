package com.example.Trips.controller;
import com.example.Trips.model.Trip;
import com.example.Trips.service.TripService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebMvcTest(TripController.class)
public class TripControllerTest {
    @MockBean
    private TripService tripService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createTripTest() throws Exception {
        Trip trip = new Trip();
        trip.setId(2);
        // When
        Mockito.when(tripService.createTrip(Mockito.any(Trip.class)))
                .thenReturn(trip);
        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.post("/api/vi/trips")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(trip)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getTripsTest() throws Exception {
        Trip trip1 = new Trip();
        trip1.setId(1);
        Trip trip2 = new Trip();
        trip2.setId(2);
        Trip trip3 = new Trip();
        trip3.setId(3);
        List<Trip> trips = Arrays.asList(trip1, trip2, trip3);

        // When
        Mockito.when(tripService.getAllTrips()).thenReturn(trips);


        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.get("/api/vi/trips"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(3));

    }

    @Test
    public void getByIdTripTest() throws Exception{
        Long id = 1L;
        Trip trip = new Trip();
        trip.setId(id);
        // When
        Mockito.when(tripService.getTripById(id))
                .thenReturn(Optional.of(trip));

        // Perfom the test
        mockMvc.perform(MockMvcRequestBuilders.get("/api/vi/trips/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));

    }

    @Test
    public void deleteTripTest() throws Exception {
        Long id = 1L;

        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/vi/trips/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }
}
