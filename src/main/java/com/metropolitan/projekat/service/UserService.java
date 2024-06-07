package com.metropolitan.projekat.service;

import com.metropolitan.projekat.entiteti.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
    User getUserById(Long id);
    List<User> getAllUsers();
    Optional<User> findByUsername(String username);
}
