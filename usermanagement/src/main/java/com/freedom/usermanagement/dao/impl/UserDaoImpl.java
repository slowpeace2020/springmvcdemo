package com.freedom.usermanagement.dao.impl;

import com.freedom.usermanagement.dao.UserDao;
import com.freedom.usermanagement.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

public class UserDaoImpl implements UserDao {

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private JdbcTemplate jdbcTemplate;


  @Override
  public List<User> findAll() {
    List<User> users = jdbcTemplate.query("select * from sys_user",new BeanPropertyRowMapper<>(User.class));
    return users;
  }

  /**
   * 返回用户ID
   * @param user
   * @return
   */
  @Override
  public Long save(User user) {
    //创建PreparedStatementCreator
    PreparedStatementCreator creator = new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values(?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setObject(1,null);
        preparedStatement.setObject(2,user.getUsername());
        preparedStatement.setObject(3,user.getEmail());
        preparedStatement.setObject(4,user.getPassword());
        preparedStatement.setObject(5,user.getPhoneNum());
        return preparedStatement;
      }
    };
    //创建keyholder
    GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(creator,keyHolder);
    Long userId = keyHolder.getKey().longValue();

    return userId;
  }

  @Override
  public void saveUserRoleRelation(Long userId, Long[] roleIds) {
    for(long roleId:roleIds){
      jdbcTemplate.update("insert into sys_user_role values(?,?)",userId,roleId);
    }
  }

  @Override
  public void delUserRoleRel(Long userId) {
    jdbcTemplate.update("delete from sys_user_role where userId=?",userId);
  }

  @Override
  public void delUser(Long userId) {
    jdbcTemplate.update("delete from sys_user where id=? ;",userId);
  }
}
