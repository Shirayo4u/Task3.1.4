package com.example.ProjectBoot1.dao;

import com.example.ProjectBoot1.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> getRoleByName(String roleName) {
        Set<Role> roles = new HashSet<>();
        for (Role role : getRoles()) {
            if (roleName.contains(role.getRoleName())) {
                roles.add(role);
            }
        }
        return roles;
    }

    @Override
    public List<Role> getRoles() {
        return entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }

    @Override
    public Role getRoleById(long id) {
        return entityManager.find(Role.class, id);
    }
}

