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
  
