package com.example.ProjectBoot1.dao;


import com.example.ProjectBoot1.model.Role;

import java.util.Set;

public interface RoleDao {
    Set<Role> getRoles();

    Role getRoleById(Long id);
}
