package com.freedom.study.domain;

import java.util.List;

public class ViewOut {

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }

  @Override
  public String toString() {
    return "ViewOut{" +
        "userList=" + userList +
        '}';
  }

  private List<User> userList;

}
