package com.example.demo.models.Subscription;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionContext {

    private SubscriptionStrategy subscriptionStrategy;

    public void executeStrategy() {
        subscriptionStrategy.subscribe();
    }
}
