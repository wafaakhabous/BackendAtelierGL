package com.example.Trips.controller;

import com.example.Trips.model.Blog;
import com.example.Trips.model.Itinerary;
import com.example.Trips.model.Trip;
import com.example.Trips.request.MultiStepRequest;
import com.example.Trips.service.BlogService;
import com.example.Trips.service.ItineraryService;
import com.example.Trips.service.TripService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vi/blogs")
@CrossOrigin(origins = "http://localhost:3000")
public class BlogController {
    private final BlogService blogService;
    private final TripService tripService;
    private final ItineraryService itineraryService;

    @Autowired
    public BlogController(BlogService blogService, TripService tripService, ItineraryService itineraryService) {
        this.blogService = blogService;
        this.tripService = tripService;
        this.itineraryService = itineraryService;
    }

    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable long id) {
        return blogService.getBlogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {

        return blogService.saveBlog(blog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable long id, @RequestBody Blog blog) {
        if (blogService.getBlogById(id).isPresent()) {
            blog.setId(id);
            return ResponseEntity.ok(blogService.saveBlog(blog));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable long id) {
        /**
        if (blogService.getBlogById(id).isPresent()) {
            blogService.deleteBlog(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
         **/
        blogService.deleteBlog(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/AddBlog")
    @Transactional
    public ResponseEntity<Blog> addBlogTransactionnal(@RequestBody MultiStepRequest request) throws ParseException
    {
        /** Itinerary 1 **/
        Itinerary itinerary1 = new Itinerary();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate;
        utilDate = dateFormat.parse(request.getDate_start_1());
        itinerary1.setDatestart(new Date(utilDate.getTime()));
        utilDate = dateFormat.parse(request.getDate_end_1());
        itinerary1.setDateend(new Date(utilDate.getTime()));
        itinerary1.setCityName(request.getCityname1());

        /** Itinerary 2 **/
        Itinerary itinerary2 = new Itinerary();
        utilDate = dateFormat.parse(request.getDate_start_2());
        itinerary2.setDatestart(new Date(utilDate.getTime()));
        utilDate = dateFormat.parse(request.getDate_end_2());
        itinerary2.setDateend(new Date(utilDate.getTime()));
        itinerary2.setCityName(request.getCityname2());



        /** Trip **/
        Trip trip = new Trip();
        utilDate = dateFormat.parse(request.getDate_start_trip());
        trip.setDatestart(new Date(utilDate.getTime()));
        utilDate = dateFormat.parse(request.getDate_end_trip());
        trip.setDateend(new Date(utilDate.getTime()));
        trip.getItineraries().add(itinerary1);
        trip.getItineraries().add(itinerary2);

        /** Blog **/
        Blog blog = new Blog();
        blog.setDescription(request.getDescription());
        blog.setTrip(trip);
        trip.setBlog(blog);
        blogService.createTripAndBlog(trip,blog);
        return ResponseEntity.ok(blog);
    }
}

