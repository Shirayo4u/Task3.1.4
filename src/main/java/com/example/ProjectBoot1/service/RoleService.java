package com.example.ProjectBoot1.service;

import com.example.ProjectBoot1.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Set<Role> getRoles();
    Set<Role> findRolesByName(String name);
}
