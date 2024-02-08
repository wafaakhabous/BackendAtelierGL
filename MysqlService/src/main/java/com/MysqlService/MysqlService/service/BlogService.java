package com.MysqlService.MysqlService.service;

import com.MysqlService.MysqlService.model.Blog;
import com.MysqlService.MysqlService.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    public void deleteById(long id) {
        blogRepository.deleteById(id);
    }

    public Optional<Blog> findById(long id) {
        return blogRepository.findById(id);
    }

    public List<Blog> findAll() {
        return blogRepository.findAll();
    }
}
