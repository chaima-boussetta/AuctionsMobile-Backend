package com.example.demo.Controller;

import com.example.demo.Service.CommentService;
import com.example.demo.Model.Comment;
import com.example.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {

    @Autowired
    private CommentService commentService;


    /*get all comments from username*/

    @RequestMapping("/users/{username}/feedbacks/from")
    public List<Comment> getAllFromComments(@PathVariable String username){
        return commentService.getAllFromComments(username);
    }

    /*get all comments to username*/

    @RequestMapping("/users/{username}/feedbacks/to")
    public List<Comment> getAllToComments(@PathVariable String username){
        return commentService.getAllToComments(username);
    }

    @RequestMapping(method= RequestMethod.POST, value = "/users/{fromWhom}/feedbacks/{toWhom}")
    public void addComment(@RequestBody String description, @PathVariable String fromWhom, @PathVariable String toWhom){
        Comment comment = new Comment(description,new User(fromWhom,"","","", "",100,0),new User(toWhom,"", "","", "",100,0));
        commentService.addComment(comment);
    }


    @RequestMapping("/feedbacks")
    public String getAll(){
        return "Recuest";
    }



}

