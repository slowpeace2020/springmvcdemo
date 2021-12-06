package com.freedom.study.web;

import com.freedom.study.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserService userService = app.getBean(UserService.class);
    userService.save();
  }
}
