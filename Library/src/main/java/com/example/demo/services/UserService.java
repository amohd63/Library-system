package com.example.demo.services;

import org.springframework.stereotype.Service;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(User user) {
        if (userRepository.existsUserByUserName(user.getUserName())) {
            return "User already registered in the database!";
        }
        userRepository.save(user);
        return "User added successfully!";
    }

    public User getUser(String userName) {
        return userRepository.findUserByUserName(userName).get();
    }

    public User updateUser(User user) {
        User userObj = userRepository.findUserByUserName(user.getUserName()).get();
        if (userObj == null){
            return null;
        }
        user.setUserID(userObj.getUserID());
        return userRepository.save(user);
    }

    public int deleteUser(String userName) {
        return userRepository.deleteUserByUserName(userName);
    }
}