package com.MysqlService.MysqlService.controller;

import com.MysqlService.MysqlService.model.Blog;
import com.MysqlService.MysqlService.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vi/blogs")
public class BlogController {
    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") long id) {
        blogService.deleteById(id);
    }

    @PostMapping("/Add")
    Blog save(@RequestBody Blog blog) {
        return blogService.save(blog);
    }

    @GetMapping("/{id}")
    Optional<Blog> findById(@PathVariable("id") long id) {
        return blogService.findById(id);
    }

    @GetMapping("/All")
    List<Blog> findAll() {
        return blogService.findAll();
    }
}
