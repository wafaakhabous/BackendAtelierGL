package com.example.Trips.controller;

import com.example.Trips.model.Comment;
import com.example.Trips.service.CommentService;
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

@WebMvcTest(CommentController.class)
public class CommentControllerTest {
    @MockBean
    private CommentService commentService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createCommentTest() throws Exception {
        Comment comment = new Comment();
        comment.setId(1);
        // When
        Mockito.when(commentService.saveComment(Mockito.any(Comment.class)))
                .thenReturn(comment);
        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.post("/api/vi/comments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comment)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getCommentsTest() throws Exception {
        Comment comment1 = new Comment();
        comment1.setId(1);
        Comment comment2 = new Comment();
        comment2.setId(2);
        List<Comment> comments = Arrays.asList(comment2, comment1);
        // When
        Mockito.when(commentService.getAllComments()).thenReturn(comments);
        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.get("/api/vi/comments"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(1));
    }

    @Test
    public void getByIdCommentTest() throws Exception {
        Long id = 1L;
        Comment comment = new Comment();
        comment.setId(id);
        // When
        Mockito.when(commentService.getCommentById(id))
                .thenReturn(comment);
        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.get("/api/vi/comments/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
    }

    @Test
    public void deleteCommentTest() throws Exception {
        Long id = 1L;

        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/vi/comments/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
