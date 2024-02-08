package com.example.Trips.controller;

import com.example.Trips.model.Blog;
import com.example.Trips.service.BlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebMvcTest(BlogController.class)
public class BlogControllerTest {
    @MockBean
    private BlogService blogService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createBlogTest() throws Exception {
        Long id = 1L;
        Blog blog = new Blog();
        blog.setId(id);
        // When
        Mockito.when(blogService.saveBlog(Mockito.any(Blog.class)))
                .thenReturn(blog);
        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.post("/api/vi/blogs")
               .contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(blog)))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getBlogsTest() throws Exception {
        Blog blog1 = new Blog();
        blog1.setId(1);
        Blog blog2 = new Blog();
        blog2.setId(2);
        List<Blog> blogList = Arrays.asList(blog1, blog2);
        // When
        Mockito.when(blogService.getAllBlogs()).thenReturn(blogList);
        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.get("/api/vi/blogs"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2));
    }

    @Test
    public void getByIdBlogTest() throws Exception {
        Long id = 1l;
        Blog blog = new Blog();
        blog.setId(id);
        // When
        Mockito.when(blogService.getBlogById(id))
                .thenReturn(Optional.of(blog));
        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.get("/api/vi/blogs/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));

    }

    @Test
    public void deleteBlogTest() throws Exception {
        Long id = 1L;

        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/vi/blogs/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

}
