package com.example.demo.repositories;

import com.example.demo.models.Subscription.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    boolean existsSubscriptionByUserID(Integer userID);

    Subscription findSubscriptionByUserID(Integer userID);

    int deleteSubscriptionByUserID(Integer userID);
}
