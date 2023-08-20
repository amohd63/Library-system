package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Subscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    boolean existsSubscriptionByUserID(Integer userID);

    Subscription findSubscriptionByUserID(Integer userID);

    int deleteSubscriptionByUserID(Integer userID);
}
