package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.models.Borrow;
import com.example.demo.models.Subscription;
import com.example.demo.models.User;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.BorrowRepository;
import com.example.demo.repositories.SubscriptionRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {
    @Autowired
    SubscriptionRepository subscriptionRepository;

    public String subscribe(Subscription subscription) {
        if (subscriptionRepository.existsSubscriptionByUserID(subscription.getUserID())) {
            Subscription userSubscription = subscriptionRepository.findSubscriptionByUserID(subscription.getUserID());
            if (userSubscription.getEndDate().before(Date.valueOf(LocalDate.now()))) {
                return "Your subscription ended, renew it!";
            }
            return "User already subscribed to the library.";
        }
        subscriptionRepository.save(subscription);
        return "User subscribed to the library!";
    }

    public String renewSubscription(Subscription subscription) {
        if (subscriptionRepository.existsSubscriptionByUserID(subscription.getUserID())) {
            Subscription userSubscription = subscriptionRepository.findSubscriptionByUserID(subscription.getUserID());
            userSubscription.setStartDate(subscription.getStartDate());
            userSubscription.setEndDate(subscription.getEndDate());
            subscriptionRepository.saveAndFlush(userSubscription);
            return "Subscription renewed successfully!";
        }
        return "User is not subscribed in the library!";
    }

    public Subscription getUserSubscription(Integer userID) {
        return subscriptionRepository.findSubscriptionByUserID(userID);
    }

    public int deleteSubscription(Integer userID) {
        return subscriptionRepository.deleteSubscriptionByUserID(userID);
    }
}
