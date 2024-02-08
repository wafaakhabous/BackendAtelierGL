package com.MysqlService.MysqlService.controller;

import com.MysqlService.MysqlService.model.Comment;
import com.MysqlService.MysqlService.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vi/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService Service)
    {
        this.commentService = Service;
    }

    @PostMapping
    Comment save(@RequestBody Comment comment) {

        return commentService.save(comment);
    }

    @GetMapping("/forBlog/{id}")
    List<Comment> findAllBlog(@PathVariable long id){
        return commentService.findAllBlog(id);
    }


    @GetMapping("/All")
    List<Comment> findAll(){return commentService.findAll();}

    @GetMapping("/{id}")
    Optional<Comment> findById(@PathVariable long id){
        return commentService.findById(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable long id){
        commentService.deleteById(id);
    }
}
