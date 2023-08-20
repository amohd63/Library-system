package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsUserByUserName(String userName);

    User findUserByUserName(String userName);

    @Transactional
    int deleteUserByUserName(String userName);
}
