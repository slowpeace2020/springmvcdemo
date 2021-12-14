package com.freedom.usermanagement.service.impl;

import com.freedom.usermanagement.dao.RoleDao;
import com.freedom.usermanagement.domain.Role;
import com.freedom.usermanagement.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements RoleService {


  //注解方式set，必须有set方法
  public void setRoleDao(RoleDao roleDao) {
    this.roleDao = roleDao;
  }

  @Autowired
  private RoleDao roleDao;


  @Override
  public List<Role> list() {
    List<Role> roleList = roleDao.findAll();
    return roleList;
  }
}
