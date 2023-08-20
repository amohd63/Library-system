package com.example.demo.services;

import com.example.demo.models.Subscription;
import com.example.demo.repositories.SubscriptionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureMockMvc
@WebMvcTest
public class SubscriptionServiceTests {

    @Mock
    private SubscriptionRepository subscriptionRepository;

    @InjectMocks
    private SubscriptionService subscriptionService;

    private Subscription subscription;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void fillData() {
        subscription = new Subscription(1, 1, Date.valueOf("2023-01-01"), Date.valueOf("2023-12-31"));
    }

    @Test
    public void getUserSubscription_success() {
        when(subscriptionService.getUserSubscription(subscription.getUserID())).thenReturn(subscription);
        Subscription subscriptionObj = subscriptionService.getUserSubscription(subscription.getUserID());
        assertNotNull(subscriptionObj);
        assertThat(subscriptionObj.getUserID()).isNotEqualTo(null);
    }
}