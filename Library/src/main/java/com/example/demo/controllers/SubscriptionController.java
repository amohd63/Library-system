package com.example.demo.controllers;

import com.example.demo.models.Subscription.PremiumSubscription;
import com.example.demo.models.Subscription.Subscription;
import com.example.demo.models.Subscription.SubscriptionContext;
import com.example.demo.models.Subscription.SubscriptionStrategy;
import com.example.demo.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
