package com.freedom.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TargetController {

  @RequestMapping("target")
  public ModelAndView show(){
    System.out.println("TargetController show.....");
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("name","太妃");
    modelAndView.setViewName("index");
    return modelAndView;
  }
}
