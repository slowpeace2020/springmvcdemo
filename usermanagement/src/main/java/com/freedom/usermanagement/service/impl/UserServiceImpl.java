package com.freedom.usermanagement.service.impl;

import com.freedom.usermanagement.dao.RoleDao;
import com.freedom.usermanagement.dao.UserDao;
import com.freedom.usermanagement.domain.Role;
import com.freedom.usermanagement.domain.User;
import com.freedom.usermanagement.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }


  private UserDao userDao;

  public void setRoleDao(RoleDao roleDao) {
    this.roleDao = roleDao;
  }

  private RoleDao roleDao;

  @Override
  public List<User> list() {
    List<User> userList = userDao.findAll();
    for(User user:userList){
      Long id = user.getId();
      List<Role> roles = roleDao.findRoleByUserId(id);
      user.setRoles(roles);

    }
    return userList;
  }

  @Override
  public void save(User user, Long[] roleIds) {
    Long userId = userDao.save(user);
    userDao.saveUserRoleRelation(userId,roleIds);
  }

  @Override
  public void del(Long userId) {
    //删除user-role表
    userDao.delUserRoleRel(userId);
    //删除user表
    userDao.delUser(userId);

  }
}
