package com.freedom.usermanagement.dao;

import com.freedom.usermanagement.domain.User;
import java.util.List;

public interface UserDao {

  List<User> findAll();

  Long save(User user);

  void saveUserRoleRelation(Long id, Long[] roleIds);

  void delUserRoleRel(Long userId);

  void delUser(Long userId);
}
