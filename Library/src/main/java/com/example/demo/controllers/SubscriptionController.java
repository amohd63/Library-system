package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.models.Borrow;
import com.example.demo.models.Subscription;
import com.example.demo.models.User;
import com.example.demo.services.SubscriptionService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscribe")
public class SubscriptionController {
    @Autowired
    SubscriptionService service;

    @PostMapping
    public String subscribe(@RequestBody Subscription subscription) {
        return service.subscribe(subscription);
    }

    @PutMapping
    public String renewSubscription(@RequestBody Subscription subscription) {
        return service.renewSubscription(subscription);
    }

    @GetMapping(params = "userID")
    public Subscription getUserSubscription(@RequestParam Integer userID) {
        return service.getUserSubscription(userID);
    }

    @DeleteMapping(params = "userID")
    public int deleteUserSubscription(@RequestParam Integer userID) {
        return service.deleteSubscription(userID);
    }
}
