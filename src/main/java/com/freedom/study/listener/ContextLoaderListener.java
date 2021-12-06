package com.freedom.study.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextLoaderListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext servletContext = sce.getServletContext();

    //读取web.xml中的全局参数
    String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");

    ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
    //将ApplicationContext(Spring的应用上下文对象)存储到最大的域servletContext域中
    servletContext.setAttribute("app",app);
    System.out.println("Spring容器创建完毕");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
  }
}
