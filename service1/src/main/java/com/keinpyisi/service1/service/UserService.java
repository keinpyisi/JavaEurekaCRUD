package com.keinpyisi.service1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keinpyisi.service1.model.User;
import com.keinpyisi.service1.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
    public Optional<User> getUserById(int id) {
        return userRepository.getUserById(id);
    }
    public void addUser(User user) {
        userRepository.addUser(user);
    }
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }
}
