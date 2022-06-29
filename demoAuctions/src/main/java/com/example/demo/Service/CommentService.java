package com.example.demo.Service;

import com.example.demo.Model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;


    public List<Comment> getAllFromComments(String username){
        System.out.println(1);
        List<Comment> comments = new ArrayList<>();
        commentRepository.findByFromWhomUsername(username)
                .forEach(comments::add);
        return comments;

    }

    public List<Comment> getAllToComments(String username){

        System.out.println(0);
        List<Comment> comments = new ArrayList<>();
        commentRepository.findByToWhomUsername(username)
                .forEach(comments::add);

        return comments;

    }

    public void addComment(Comment comment) {

        commentRepository.save(comment);
    }


}

