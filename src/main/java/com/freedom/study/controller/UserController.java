package com.freedom.study.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freedom.study.domain.User;
import com.freedom.study.domain.ViewOut;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

  @RequestMapping("/quick2")
  public ModelAndView save2(){
    System.out.println("UserController rusave2 nning.....");
    /**
     * Model 模型 封装数据
     * view 视图 展示数据
     */

    ModelAndView modelAndView = new ModelAndView();
    //设置模型数据，相当于放进request域中，键值对形式
    modelAndView.addObject("username","women");
    //设置视图名称
    modelAndView.setViewName("success");

    return modelAndView;
  }

  @RequestMapping("/quick3")
  public ModelAndView save3(ModelAndView modelAndView){
    System.out.println("UserController save3 nning.....");


    //设置模型数据，相当于放进request域中，键值对形式
    modelAndView.addObject("username","women comming");
    //设置视图名称
    modelAndView.setViewName("success");
    System.out.println(modelAndView.getView());

    return modelAndView;
  }

  @RequestMapping("/quick4")
  public String save4(Model model){
    System.out.println("UserController save4 nning.....");


    //设置模型数据，相当于放进request域中，键值对形式
    model.addAttribute("username","women");
    //设置视图名称

    return "success";
  }

  @RequestMapping("/quick5")
  public String save5(HttpServletRequest request){
    System.out.println("UserController save5 nning.....");


    //设置模型数据，相当于放进request域中，键值对形式
    request.setAttribute("username","stand up");
    //设置视图名称

    return "success";
  }

  /**
   * 回写数据
   * @param response
   * @return
   */
  @RequestMapping("/quick6")
  public void write(HttpServletResponse response){
    System.out.println("UserController write nning.....");

    try {
      response.getWriter().println("hello sister");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @RequestMapping("/quick7")
  @ResponseBody//告知springmvc框架 不进行视图页面跳转 直接进行数据响应
  public String write2(){
    System.out.println("UserController write2 nning.....");
    return "hello sisters";
  }

  @RequestMapping("/quick8")
  @ResponseBody//返回json数据
  public String write3() throws JsonProcessingException {
    User user = new User();
    user.setAge(29);
    user.setName("Ann");
    user.setId(1);
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(user);
    return json;
  }

  @RequestMapping("/quick9")
  @ResponseBody//返回json数据
  public User write4() {
    User user = new User();
    user.setAge(30);
    user.setName("By pass");
    user.setId(1);

    return user;
  }

  @RequestMapping("/quick10")
  @ResponseBody
  public void write5(String username,int age) {
    System.out.println(username);
    System.out.println(age);
  }

  @RequestMapping("/quick11")
  @ResponseBody
  public void write6(User user) {
    System.out.println("entity auto find....");
    System.out.println(user.getName());
    System.out.println(user.getAge());
  }

  @RequestMapping("/quick12")
  @ResponseBody
  public void write7(String[] strs) {
    System.out.println("array auto find....");
    System.out.println(Arrays.asList(strs));
  }

  @RequestMapping(value = "/quick13",method = RequestMethod.POST)
  @ResponseBody
  public void write8(ViewOut viewOut) {
    System.out.println("list auto find....");
    System.out.println(viewOut.getUserList());
  }

  @RequestMapping(value = "/quick14",method = RequestMethod.POST)
  @ResponseBody
  public void write9(@RequestBody List<User> userList) {
    System.out.println("RequestBody list auto find....");
    System.out.println(userList);
  }

  @RequestMapping(value = "/quick15")
  @ResponseBody
  public void write10(@RequestParam("name") String username) {
    System.out.println("RequestBody write10 auto find....");
    System.out.println(username);
  }

  @RequestMapping(value = "/quick16/{username}")
  @ResponseBody
  public void save16(@PathVariable(value = "username") String username) {
    System.out.println("RequestBody save16 auto find....");
    System.out.println(username);
  }

  @RequestMapping(value = "/quick17")
  @ResponseBody
  public void save17(Date date) {
    System.out.println("RequestBody save17 auto find....");
    System.out.println(date);
  }

  @RequestMapping(value = "/quick18")
  @ResponseBody
  public void save18(@RequestHeader(value = "User-Agent", required = false) String userAgent) {
    System.out.println("RequestHeader quick18 auto find....");
    System.out.println(userAgent);
  }

  @RequestMapping(value = "/quick19")
  @ResponseBody
  public void save19(@CookieValue(value = "JSESSIONID", required = false) String jsessionId) {
    System.out.println("RequestHeader save19 auto find....");
    System.out.println(jsessionId);
  }

}
