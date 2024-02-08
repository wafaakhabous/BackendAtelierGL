package com.example.Trips.client;

import com.example.Trips.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Data-service-COMMENT",  url = "${application.config.DataCOMM-url}")

public interface Datacomment {

    @PostMapping
    Comment save(@RequestBody Comment comment);

    @GetMapping("/{id}")
    Optional<Comment> findById(@PathVariable long id);

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable long id);

    @GetMapping("/All")
    List<Comment> findAll();

    @GetMapping("/forBlog/{id}")
    List<Comment> findAllBlog(@PathVariable("id") long id);
}
