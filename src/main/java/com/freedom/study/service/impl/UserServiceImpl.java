package com.freedom.study.service.impl;

import com.freedom.study.dao.UserDao;
import com.freedom.study.service.UserService;

public class UserServiceImpl implements UserService {

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  private UserDao userDao;

  @Override
  public void save() {
    userDao.save();
  }
}
