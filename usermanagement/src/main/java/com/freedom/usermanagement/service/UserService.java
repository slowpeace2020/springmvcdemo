package com.freedom.usermanagement.service;

import com.freedom.usermanagement.domain.User;
import java.util.List;

public interface UserService {

  List<User> list();

  void save(User user, Long[] roleIds);

  void del(Long userId);
}
