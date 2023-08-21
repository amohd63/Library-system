package com.example.demo.models.Subscription;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
@NoArgsConstructor
@DiscriminatorValue("PremiumSubscription")
public class PremiumSubscription extends Subscription implements SubscriptionStrategy {
    private static final int BORROW_LIMIT = 4;

    @Override
    public void subscribe() {
        this.setBorrowLimit(BORROW_LIMIT);
    }
}
