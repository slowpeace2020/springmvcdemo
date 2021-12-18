package com.freedom.usermanagement.service;

import com.freedom.usermanagement.domain.Role;
import java.util.List;

public interface RoleService {

  List<Role> list();

  void save(Role role);
}
