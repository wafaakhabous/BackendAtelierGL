package com.example.Trips.service;

import com.example.Trips.client.Data;
import com.example.Trips.client.DataTrip;
import com.example.Trips.model.Blog;
import com.example.Trips.model.Trip;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BlogService {

    private Data client;
    private DataTrip trip_data;

    public List<Blog> getAllBlogs() {
        return client.findAll();
    }

    public Optional<Blog> getBlogById(long id) {
        return client.findById(id);
    }

    public Blog saveBlog(Blog blog) {
        return client.save(blog);
    }

    public void deleteBlog(long id) {
        client.deleteById(id);
    }
    @Transactional
    public void createTripAndBlog(Trip trip, Blog blog){
         trip_data.save(trip);
         client.save(blog);
    }
}
