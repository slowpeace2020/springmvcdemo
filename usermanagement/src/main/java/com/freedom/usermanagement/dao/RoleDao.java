package com.freedom.usermanagement.dao;

import com.freedom.usermanagement.domain.Role;
import java.util.List;

public interface RoleDao {

  List<Role> findAll();
}