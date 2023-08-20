package com.example.demo.controllers;

import com.example.demo.models.Subscription.Subscription;
import com.example.demo.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscribe")
public class SubscriptionController {
    @Autowired
    SubscriptionService service;

    @GetMapping(params = "type")
    @PostMapping
    public String subscribe(@RequestBody Subscription subscription, @RequestParam("type") String subscriptionType) {
        return service.subscribe(subscription, subscriptionType);
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
