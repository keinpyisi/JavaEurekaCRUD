package com.keinpyisi.service1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.keinpyisi.service1.model.User;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers() {
        String query = "SELECT * FROM user";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));
    }

    public Optional<User> getUserById(int id) {
        String query = "SELECT * FROM user WHERE id = ?";
        List<User> users = jdbcTemplate.query(query, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }
    
    public void addUser(User user) {
        String query = "INSERT INTO user (id, name, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, user.getId(), user.getName(), user.getEmail());
    }

    public void updateUser(User user) {
        String query = "UPDATE user SET name = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(query, user.getName(), user.getEmail(), user.getId());
    }

    public void deleteUser(int id) {
        String query = "DELETE FROM user WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}