package com.example.Trips.controller;

import com.example.Trips.model.Itinerary;
import com.example.Trips.service.ItineraryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebMvcTest(ItineraryController.class)
public class ItineraryControllerTest {
    @MockBean
    private ItineraryService itineraryService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createItineraryTest() throws Exception {
        Long id = 1L;
        Itinerary itinerary = new Itinerary();
        itinerary.setId(id);
        // When
        Mockito.when(itineraryService.saveItinerary(Mockito.any(Itinerary.class)))
                .thenReturn(itinerary);
        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.post("/api/itinerary")
               .contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(itinerary)))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
    }


    @Test
    public void getItinerariresTest() throws Exception {
        Itinerary itinerary1 = new Itinerary();
        itinerary1.setId(1);
        Itinerary itinerary2 = new Itinerary();
        itinerary2.setId(2);
        List<Itinerary> itineraryList = Arrays.asList(itinerary1, itinerary2);
        // When
        Mockito.when(itineraryService.getAllItinerary()).thenReturn(itineraryList);
        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.get("/api/itinerary"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2));

    }

    @Test
    public void getItineraryByIdTest() throws Exception {
        Long id = 1L;
        Itinerary itinerary = new Itinerary();
        itinerary.setId(id);
        // When
        Mockito.when(itineraryService.getItineraryById(id))
                .thenReturn(Optional.of(itinerary));
        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.get("/api/itinerary/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
    }

    @Test
    public void deleteItineraryTest() throws Exception {
        Long id = 1L;
        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/itinerary/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
