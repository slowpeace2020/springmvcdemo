package com.freedom.study.listener;

import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;

public class WebApplicationContextutils {

  //统一命名获取ApplicationContext
  public static ApplicationContext getWebApplicationContext(ServletContext servletContext){
    return (ApplicationContext) servletContext.getAttribute("app");
  }
}
