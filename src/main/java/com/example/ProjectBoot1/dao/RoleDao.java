package com.example.ProjectBoot1.dao;

import com.example.ProjectBoot1.model.Role;
import java.util.List;
import java.util.Set;

public interface RoleDao {
    Set<Role> getRoleByName(String roleName);
    List<Role> getRoles();
    Role getRoleById(long id);
}
