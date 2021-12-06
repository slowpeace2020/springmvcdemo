##Spring集成web环境
###ApplicationContext应用上下文获取方式

  应用上下文对象通过new ClassPathXmlApplicationContext(spring配置文件)方式获取，但每次从容器中获取Bean都要编写new ClassPathXmlApplicationContext(spring配置文件)，使得配置文件加载多次，应用上下文对象创建多次  

  
  在web项目中，使用ServletContextListener监听web应用的启动，在web应用启动时就加载Spring的配置文件，创建应用上下文对象ApplicationContext,将其存储到最大的域servletContext域中，这样可以在任意位置从域中获得ApplicationContext对象
  

###Spring提供获取上下文应用的工具
* 两步实现应用
  * 在web.xml中配置ContextLoaderListener监听器（导入Spring-web依赖）
  
  ```
      <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-web</artifactId>
    <version>5.0.5.RELEASE</version>
  </dependency>
  ```
  * 