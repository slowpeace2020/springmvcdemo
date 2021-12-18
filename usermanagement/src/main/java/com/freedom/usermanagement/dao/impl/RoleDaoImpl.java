package com.freedom.usermanagement.dao.impl;

import com.freedom.usermanagement.dao.RoleDao;
import com.freedom.usermanagement.domain.Role;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class RoleDaoImpl implements RoleDao {

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Role> findAll() {
    List<Role> roleList = jdbcTemplate.query("select * from sys_role",new BeanPropertyRowMapper<>(Role.class));
    return roleList;
  }

  @Override
  public void save(Role role) {
    jdbcTemplate.update("insert into sys_role values(?,?,?)",null,role.getRoleName(),role.getRoleDesc());
  }

  @Override
  public List<Role> findRoleByUserId(Long id) {
    List<Role> roleList = jdbcTemplate.query("select * from sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId=? ",new BeanPropertyRowMapper<>(Role.class),id);
    return roleList;
  }
}
