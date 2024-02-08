package com.MysqlService.MysqlService.service;

import com.MysqlService.MysqlService.model.Comment;
import com.MysqlService.MysqlService.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository Repository) {
        this.commentRepository = Repository;
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    public Optional<Comment> findById(long id) {
        return commentRepository.findById(id);
    }

    public void deleteById(long id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public List<Comment> findAllBlog(long id) {
        return commentRepository.findByBlogId(id);
    }
}
