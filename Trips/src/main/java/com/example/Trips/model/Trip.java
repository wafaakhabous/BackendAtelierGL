package com.example.Trips.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date datestart;
    private Date dateend;
    //@JsonBackReference("Trip_User")
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private User publisher;
    @JsonBackReference("Blog_Trip")
    @OneToOne(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = false)
    private Blog blog;
    @JsonManagedReference("Trip_Itinerary")
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Itinerary> itineraries = new ArrayList<>();

}
