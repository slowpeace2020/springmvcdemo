package com.freedom.study.web;

import com.freedom.study.listener.WebApplicationContextutils;
import com.freedom.study.service.UserService;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class UserServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
//降低耦合程度
//    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
    ServletContext servletContext = req.getServletContext();
//    ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");
//    ApplicationContext app = WebApplicationContextutils.getWebApplicationContext(servletContext);

    ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    UserService userService = app.getBean(UserService.class);
    userService.save();
  }
}
