package com.example.demo.Service;

import com.example.demo.Model.User;


public interface SecurityService {

    void autologin(String username, String password);

    boolean loginUser(String username, String password);

    User getAuthenticatedUser();

}
