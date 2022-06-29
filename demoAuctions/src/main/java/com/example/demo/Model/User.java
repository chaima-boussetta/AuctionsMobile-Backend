package com.example.demo.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long Id;

    @Size(min=3, max=20,
            message="firstname must be between 3 and 20 characters long.")
    @Pattern(regexp="^[a-zA-Z0-9]+$",
            message="firstname must be alphanumeric with no spaces")
    private String firstName;
    @Size(min=3, max=20,
            message="Username must be between 3 and 20 characters long.")
    @Pattern(regexp="^[a-zA-Z0-9]+$",
            message="Username must be alphanumeric with no spaces")
    private String username;


    @Size(min=3, max=20,
            message="lastname must be between 3 and 20 characters long.")
    @Pattern(regexp="^[a-zA-Z0-9]+$",
            message="lastname must be alphanumeric with no spaces")
    private String lastName;

    @Size(min=6, max=20,
            message="The password must be at least 6 characters long.")
    private String password;


    @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message="Invalid email address.")
    private String email;
    private double balance=100;
    private double penalty = 0;// 20% from unpaid lot

    public User(Long id) {
        Id = id;
    }

    public User(Long id, String username, String firstName, String lastName, String password, String email, double balance, double penalty) {
        Id = id;
        this.firstName = firstName;
        this.username = username;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.balance = balance;
        this.penalty = penalty;
    }

    public User(String username, String s, String s1, String s2, String s3, int i, int i1) {
    }

    public void addPenalty(double penalty) {
        this.penalty += penalty;
    }


    public void addMoney(double amount) {
        this.balance +=amount;
    }

    public void subtractMoney(double amount) {
        this.balance -= amount;
    }


}

