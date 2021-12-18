package com.freedom.usermanagement.controller;

import com.freedom.usermanagement.domain.Role;
import com.freedom.usermanagement.domain.User;
import com.freedom.usermanagement.service.RoleService;
import com.freedom.usermanagement.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private RoleService roleService;

  @RequestMapping("/list")
  public ModelAndView list(){
    List<User> userList = userService.list();
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("userList",userList);
    modelAndView.setViewName("user-list");
    return modelAndView;
  }

  @RequestMapping("/saveUI")
  public ModelAndView saveUI(){
    List<Role> roleList = roleService.list();
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("roleList",roleList);
    modelAndView.setViewName("user-add");
    return modelAndView;
  }

  @RequestMapping("/save")
  public String save(User user,Long[] roleIds){
    userService.save(user,roleIds);
    return "redirect:/user/list";
  }

  @RequestMapping("/del/{userId}")
  public String del(@PathVariable("userId") Long userId){
    userService.del(userId);
    return "redirect:/user/list";
  }

}
