package com.example.demo.models.Subscription;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
@NoArgsConstructor
@DiscriminatorValue("PremiumSubscription")
public class PremiumSubscription extends Subscription {
    private static final int BORROW_LIMIT = 4;
    public PremiumSubscription(Integer subscriptionID, Integer userID, Date startDate, Date endDate) {
        super(subscriptionID, userID, startDate, endDate, BORROW_LIMIT);
    }
}
