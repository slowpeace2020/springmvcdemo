package com.example.demo.service;

import com.example.demo.domain.Role;
import java.util.List;

public interface RoleService {
    public List<Role> list() ;

    void save(Role role);
}
