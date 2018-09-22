package com.sit.cloudnative.comment;

import java.util.List;
import java.util.Optional;

import com.sit.cloudnative.post.Post;
import com.sit.cloudnative.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService{

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComment(){
        return commentRepository.findAll();
    }

    public Comment create(User user_id, Post post_id, Comment comment){
        comment.setUser(user_id);
        comment.setPost(post_id);
        return commentRepository.save(comment);
    }

    public Optional<Comment> getCommentById(int id) {
        return commentRepository.findById(id);
    }

    public void deleteCommentById(int id){
        commentRepository.deleteById(id);
    }
}