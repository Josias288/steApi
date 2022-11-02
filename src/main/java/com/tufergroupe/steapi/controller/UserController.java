package com.tufergroupe.steapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tufergroupe.steapi.model.User;
import com.tufergroupe.steapi.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("user/save")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);

    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User oldUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        return oldUser;
    }

}
