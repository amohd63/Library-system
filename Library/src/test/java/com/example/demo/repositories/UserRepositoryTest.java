package com.example.demo.repositories;

import com.example.demo.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureMockMvc
@WebMvcTest
public class UserRepositoryTest {
    @Mock
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void fillData() {
        user = new User(1, "user1", "password1", "John", "Doe");
    }

    @Test
    public void getUserByUsername_success() throws Exception {
        when(userRepository.findUserByUserName(user.getUserName())).thenReturn(user);
        User userFromRepo = userRepository.findUserByUserName(user.getUserName());
        assertNotNull(userFromRepo);
        assertThat(userFromRepo.getUserID()).isNotEqualTo(null);
        assertEquals(userFromRepo.getUserName(), user.getUserName());
        assertEquals(userFromRepo.getUserPassword(), user.getUserPassword());
    }
}
