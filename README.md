##Spring集成web环境
###ApplicationContext应用上下文获取方式

  应用上下文对象通过new ClassPathXmlApplicationContext(spring配置文件)方式获取，但每次从容器中获取Bean都要编写new ClassPathXmlApplicationContext(spring配置文件)，使得配置文件加载多次，应用上下文对象创建多次  

  
  在web项目中，使用ServletContextListener监听web应用的启动，在web应用启动时就加载Spring的配置文件，创建应用上下文对象ApplicationContext,将其存储到最大的域servletContext域中，这样可以在任意位置从域中获得ApplicationContext对象
  

###Spring提供获取上下文应用的工具
* 两步实现应用
  * 在web.xml中配置ContextLoaderListener监听器（导入Spring-web依赖）
  ```
   <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
  </context-param>
  
    <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  ```
  
  
  ```
      <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-web</artifactId>
    <version>5.0.5.RELEASE</version>
  </dependency>
  ```

  * 读取web.xml中的全局参数
  ```
    String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
    ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
  ```

###快速入门
需求:客户端发起请求，服务器端接收请求，执行逻辑并进行视图跳转。 
* 开发步骤
  1. 导入SpringMVC相关坐标 
  2. 配置SpringMVC核心控制器DispathcerServlet 
  3. 创建Controller类和视图页面 
  4. 使用注解配置Controller类中业务方法的映射地址 
  5. 配置SpringMVC核心文件 spring-mvc.xml 
  6. 客户端发起请求测试

  * 相关配置
    * 依赖
    ```
      <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.0.5.RELEASE</version>
      </dependency>
    ```
  
    * web.xml
        ```
      <!--  配置前端控制器-->
      <!--配置SpringMVC的前端控制器-->
      <servlet>
        <servlet-name>DispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
          <param-name>contextConfigLocation</param-name>
          <param-value>classpath:spring-mvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
      </servlet>

        <servlet-mapping>
          <servlet-name>DispatcherServlet</servlet-name>
          <url-pattern>/</url-pattern>
        </servlet-mapping>
    
        ```
    * 添加spring-mvc.xml
        ```
        <!--Controller组件扫描-->
        <context:component-scan base-package="com.freedom.study.controller"/>
      
        ```
    
###SpringMVC执行流程
 浏览器请求-----> 前端控制器（DispatcherServlet）---->请求查询Handler---->处理映射器（HandlerMapping）

①用户发送请求至前端控制器DispatcherServlet。

②DispatcherServlet收到请求调用HandlerMapping处理器映射器。

③处理器映射器找到具体的处理器(可以根据xml配置、注解进行查找)，生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet。

④DispatcherServlet调用HandlerAdapter处理器适配器。

⑤HandlerAdapter经过适配调用具体的处理器(Controller，也叫后端控制器)。

⑥Controller执行完成返回ModelAndView。

⑦HandlerAdapter将controller执行结果ModelAndView返回给DispatcherServlet。

⑧DispatcherServlet将ModelAndView传给ViewReslover视图解析器。

⑨ViewReslover解析后返回具体View。

⑩DispatcherServlet根据View进行渲染视图（即将模型数据填充至视图中）。DispatcherServlet响应用户。
   

####springmvc注解解析
* @RequestMapping
  * 位置：
  * 类上，请求URL 的第一级访问目录。此处不写的话，就相当于应用的根目录

  * 方法上，请求 URL 的第二级访问目录，与类上的使用@ReqquestMapping标注的一级目录一起组成访问虚拟路径
     
  * 属性：
    
  * value：用于指定请求的URL。它和path属性的作用是一样的
  * method：用于指定请求的方式
  * params：用于指定限制请求参数的条件。它支持简单的表达式。要求请求参数的key和value必须和配置的一模一样



* 1. mvc命名空间引入

```xml
命名空间：xmlns:context="http://www.springframework.org/schema/context"
        xmlns:mvc="http://www.springframework.org/schema/mvc"
约束地址：http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/mvc 
        http://www.springframework.org/schema/mvc/spring-mvc.xsd
```

* 2. 组件扫描

SpringMVC基于Spring容器，所以在进行SpringMVC操作时，需要将Controller存储到Spring容器中，如果使用@Controller注解标注的话，就需要使用<context:component-scan base-package=“com.itheima.controller"/>进行组件扫描。

####springmvc的数据响应
#####响应方式
* 页面跳转
  * 返回字符串
  * 通过ModelAndView对象返回
  
* 回写数据
  * 返回字符串
  * 返回对象或者集合


ModelAndView 添加的属性取不出来？

EL表达式无法获取到Controller ModelAndView的值，Maven
自动生成的web.xml内容如下：
```
<!DOCTYPE web-app PUBLIC  
"-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"  
"http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>  

</web-app>

```

web.xml应该修改为

```
<?xml version="1.0" encoding="UTF-8"?>

<web-app version="2.5"
         xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
         http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
</web-app>

```
当有静态资源需要加载时，比如jquery文件，通过谷歌开发者工具抓包发现，没有加载到jquery文件，原因是SpringMVC的前端控制器DispatcherServlet的url-pattern配置的是/,代表对所有的资源都进行过滤操作，我们可以通过以下两种方式指定放行静态资源：


开放资源的访问权限没有成功 原因不明？以下配置同时添加到spring-mvc.xml
•使用 <mvc:default-servlet-handler/> 标签
•在spring-mvc.xml配置文件中指定放行的资源 <mvc:resources mapping="/js/**"location="/js/"/>







### 20-SpringMVC的请求-获得请求参数-Restful风格的参数的获取(应用)

Restful是一种软件架构风格、设计风格，而不是标准，只是提供了一组设计原则和约束条件。主要用于客户端和服务器交互类的软件，基于这个风格设计的软件可以更简洁，更有层次，更易于实现缓存机制等。

Restful风格的请求是使用“url+请求方式”表示一次请求目的的，HTTP 协议里面四个表示操作方式的动词如下：

GET：用于获取资源

POST：用于新建资源

PUT：用于更新资源

DELETE：用于删除资源  


### 23-SpringMVC的请求-获得请求参数-获得请求头信息(应用)

使用@RequestHeader可以获得请求头信息，相当于web阶段学习的request.getHeader(name)

@RequestHeader注解的属性如下：

value：请求头的名称

required：是否必须携带此请求头

使用@CookieValue可以获得指定Cookie的值

@CookieValue注解的属性如下：

value：指定cookie的名称

required：是否必须携带此cookie


####springmvc 使用了登录拦截器之后静态资源还是会被拦截的处理办法?
* 在spring-mvc.xml拦截器的配置里加上静态资源的处理
```
    <!--配置权限拦截器-->
    <mvc:interceptors>
        <mvc:interceptor>
            <!--配置对哪些资源执行拦截操作-->
            <mvc:mapping path="/**"/>
            <!--配置哪些资源排除拦截操作-->
            <mvc:exclude-mapping path="/user/login"/>
            <mvc:exclude-mapping path="/img/**"/>
            <mvc:exclude-mapping path="/plugins/**"/>
            <mvc:exclude-mapping path="/css/**"/>
            <bean class="com.example.demo.interceptor.PreviligeInterCeptor"/>
        </mvc:interceptor>
    </mvc:interceptors>

```





