package com.freedom.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

  @RequestMapping("/quick")
  public String save(){
    System.out.println("UserController running.....");
    //会去找user/下的资源
//    return "success.jsp";
    //找webapp目录的资源
//    return "/success.jsp";
    //前缀后缀已配置，默认转发forward:success,重定向则redirect:success
    return "success";
  }

}
