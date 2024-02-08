package com.example.Trips.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String cityName;
    private Date datestart;
    private Date dateend;
    @JsonBackReference("Trip_Itinerary")
    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;
}
