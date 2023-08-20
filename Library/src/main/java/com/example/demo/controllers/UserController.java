package com.example.demo.controllers;

import com.example.demo.models.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.models.Book;
import com.example.demo.models.Subscription;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping
    public String addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @GetMapping(params = "userName")
    public User getUser(@RequestParam String userName) {
        return service.getUser(userName);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping(params = "userName")
    public int deleteUser(@RequestParam String userName) {
        return service.deleteUser(userName);
    }
}
