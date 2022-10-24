package com.example.ProjectBoot1.service;


import com.example.ProjectBoot1.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void addUser(User user);
    void deleteUser(Long id);
    void updateUser(User user, Long id);
    User getUserByName(String name);
}