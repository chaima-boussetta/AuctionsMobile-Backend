package com.example.demo.Controller;

import com.example.demo.Service.SecurityService;
import com.example.demo.Service.UserService;
import com.example.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user){
        userService.addUser(user);
        securityService.autologin(user.getUsername(), user.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody User user){
        boolean ans = securityService.loginUser(user.getUsername(), user.getPassword());
        if (!ans)
            return new ResponseEntity<>("Password incorrect or user does not exist", HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    public ResponseEntity<?> getCurrentUser() {
        User user = securityService.getAuthenticatedUser();
        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }

    @RequestMapping("/users/user")
    public User getUser(){
        User user = securityService.getAuthenticatedUser();
        return  userService.getUser(user.getUsername());
    }


    @RequestMapping(method= RequestMethod.PUT, value = "/users/{username}")
    public void updateUser(@RequestBody User user, @PathVariable String username){
        userService.updateUser(username, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{username}")
    public void  deleteUser(@PathVariable String username){
        userService.deleteUser(username);
    }

}


