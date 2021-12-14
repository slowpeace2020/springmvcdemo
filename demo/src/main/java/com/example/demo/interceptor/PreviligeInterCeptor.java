package com.example.demo.interceptor;

import com.example.demo.domain.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class PreviligeInterCeptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    //判断用户是否登录，判断session中有没有user
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");
    if(user==null){
      response.sendRedirect(request.getContextPath()+"/login.jsp");
      return false;
    }

    return true;
  }
}
