package com.example.ProjectBoot1.service;

import com.example.ProjectBoot1.dao.RoleDao;
import com.example.ProjectBoot1.dao.UserDao;
import com.example.ProjectBoot1.model.Role;
import com.example.ProjectBoot1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    public final UserDao userDao;
    private final RoleDao roleDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao, @Lazy PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void addUser(User user, long[] listRoles) {
        Set<Role> rolesSet = new HashSet<>();
        for (long listRole : listRoles) {
            rolesSet.add(roleDao.getRoleById(listRole));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(rolesSet);
        userDao.addUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user, long[] roleId) {
        Set<Role> rolesSet = new HashSet<>();
        for (long l : roleId) {
            rolesSet.add(roleDao.getRoleById(l));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(rolesSet);
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = getUserByName(name);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid User");
        }
        return user;
    }
}