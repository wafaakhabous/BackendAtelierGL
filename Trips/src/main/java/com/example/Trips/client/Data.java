package com.example.Trips.client;

import com.example.Trips.model.Blog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Data-service-BLOG",  url = "${application.config.DataBLOG-url}")
public interface Data {

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id);

    @PostMapping("/Add")
    Blog save(@RequestBody Blog blog);

    @GetMapping("/{id}")
    Optional<Blog> findById(@PathVariable("id") long id);

    @GetMapping("/All")
    List<Blog> findAll();
}
