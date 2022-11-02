package com.tufergroupe.steapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tufergroupe.steapi.model.User;
import com.tufergroupe.steapi.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public Optional<User> getUser(final Long id) {
        return userRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }

    public User saveUser(User soute) {
        User savedSoute = userRepository.save(soute);
        return savedSoute;
    }
}
