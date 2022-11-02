package com.tufergroupe.steapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.tufergroupe.steapi.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);
}
