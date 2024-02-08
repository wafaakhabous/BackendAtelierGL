package com.example.Trips.service;

import com.example.Trips.client.Datacomment;
import com.example.Trips.model.Comment;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final Datacomment data;

    // Constructeur

    public CommentService(Datacomment comment) {
        this.data = comment;
    }

    public Comment saveComment(Comment comment) {
        // Ajoutez ici la logique de validation ou de traitement avant d'enregistrer le commentaire
        return data.save(comment);
    }

    public Comment getCommentById(long id) {
        Optional<Comment> optionalComment = data.findById(id);
        return optionalComment.orElse(null);
    }

    public void deleteComment(long id) {
        data.deleteById(id);
    }
    public void updateComment(long id, Comment updatedComment) {
        Comment existingComment = data.findById(id)
                .orElseThrow(() -> new NotFoundException("Comment not found with id: " + id));

        // Mettez à jour les propriétés nécessaires
        existingComment.setText(updatedComment.getText());
        existingComment.setTime(updatedComment.getTime());
        existingComment.setBlog(updatedComment.getBlog());

        // Enregistrez la mise à jour
        data.save(existingComment);
    }

    public List<Comment> getAllComments() {
        return data.findAll();
    }

    public List<Comment> getAllCommentsBlog(long id) {
        System.out.println("here service 1");
        return data.findAllBlog(id);
    }
}
