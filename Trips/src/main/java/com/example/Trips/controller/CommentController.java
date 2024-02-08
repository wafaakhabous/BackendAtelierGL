package com.example.Trips.controller;

import com.example.Trips.model.Comment;
import com.example.Trips.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/forBlog/{id}")
    public List<Comment> getAllCommentsBlog(@PathVariable long id) {
        System.out.println("here controller 1");
        return commentService.getAllCommentsBlog(id);
    }


    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }

    @GetMapping("/{id}")
    public Comment getComment(@PathVariable("id") long id) {
        return commentService.getCommentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable long id) {
        commentService.deleteComment(id);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable long id, @RequestBody Comment updatedComment) {
        commentService.updateComment(id, updatedComment);
        return commentService.getCommentById(id);
    }

}
