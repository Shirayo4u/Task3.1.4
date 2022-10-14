package com.example.ProjectBoot1.service;



import com.example.ProjectBoot1.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsers();
    User getUserById(int id);
    void updateUser(User user);
    void deleteUser(int id);
}