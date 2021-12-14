package com.freedom.usermanagement.controller;

import com.freedom.usermanagement.domain.Role;
import com.freedom.usermanagement.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/role")
public class RoleController {

  //set方式设置roleService
  public void setRoleService(RoleService roleService) {
    this.roleService = roleService;
  }

  //Spring配置文件注解方式设置roleService
  @Autowired
  private RoleService roleService;

  @RequestMapping("/list")
  public ModelAndView list(){
    ModelAndView modelAndView = new ModelAndView();

    List<Role> roleList = roleService.list();
    //设置模型
    modelAndView.addObject("roleList",roleList);
    //设置视图
    modelAndView.setViewName("role-list");

    return modelAndView;
  }

}
