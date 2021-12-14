package com.example.demo.service.impl;


import com.example.demo.dao.RoleDao;
import com.example.demo.domain.Role;
import com.example.demo.service.RoleService;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    public void save(Role role) {
        roleDao.save(role);
    }
}
