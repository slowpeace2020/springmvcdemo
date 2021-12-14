package com.freedom.study.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    System.out.println(" preHandle ......................");
    String param = request.getParameter("yes");
    if("yes".equals(param)){
      return true;
    }
      request.getRequestDispatcher("/error.jsp").forward(request,response);
    return false;//true放行，false不放行
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    System.out.println(" postHandle ......................");
    modelAndView.addObject("name","春姑");
    return;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    System.out.println(" afterCompletion .......................");

    return;
  }
}
