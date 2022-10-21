package com.example.ProjectBoot1.service;


import com.example.ProjectBoot1.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user, long[] listRoles);

    List<User> getUsers();

    User getUserById(long id);

    User getUserByName(String name);

    void updateUser(User user, long[] roleId);

    void deleteUser(long id);
}