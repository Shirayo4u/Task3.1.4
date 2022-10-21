package com.example.ProjectBoot1.dao;


import com.example.ProjectBoot1.model.User;
import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User getUserById(long id);
    User getUserByName(String name);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(long id);
}

