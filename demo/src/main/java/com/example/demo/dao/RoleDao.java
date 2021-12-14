package com.example.demo.dao;

import com.example.demo.domain.Role;
import java.util.List;

public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(Long id);
}
