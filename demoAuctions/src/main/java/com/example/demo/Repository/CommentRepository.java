package com.example.demo.Repository;

import com.example.demo.Model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, String> {

    public List<Comment> findByFromWhomUsername (String username);
    public List<Comment> findByToWhomUsername (String username);
    public Comment findById (long username);
}
