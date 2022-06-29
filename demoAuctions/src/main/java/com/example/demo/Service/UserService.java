package com.example.demo.Service;


import com.example.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers(){

        List<User> users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);
        return users;

    }


    public User getUser(String username){

        return userRepository.findByUsername(username);
    }

    public void addUser(User user) {

        userRepository.save(user);
    }

    public void updateUser(String username, User user) {
        userRepository.save(user);
    }


    public void deleteUser(String username) {
        userRepository.delete(username);
    }



}

