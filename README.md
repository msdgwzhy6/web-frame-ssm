# SpringMVC - Spring - MyBatis 框架整合

搭建的过程参考CSDN上的一篇文章 [SSM框架——详细整合教程（Spring+SpringMVC+MyBatis）](http://blog.csdn.net/zhshulin/article/details/37956105?utm_source=tuicool)


## 框架版本
- [Spring 4.1.6.RELEASE](http://repo.springsource.org/libs-release-local/org/springframework/spring/)
- [MyBatis 3.3.0](https://github.com/mybatis)

## 搭建过程遇见的问题

在配置SpringMVC返回的JSON的时候，按照教程上所写配置如下：
```xml
<!--避免IE执行AJAX时，返回JSON出现下载文件 -->  
<bean id="mappingJacksonHttpMessageConverter"  
    class="org.springframework.http.converter.json.MappingJacksonHttpMessageConverter">  
    <property name="supportedMediaTypes">  
        <list>  
            <value>text/html;charset=UTF-8</value>  
        </list>  
    </property>  
</bean>
    
<!-- 映入JSON -->  
<dependency>  
    <groupId>org.codehaus.jackson</groupId>  
        <artifactId>jackson-mapper-asl</artifactId>  
    <version>1.9.13</version>  
</dependency>
```

细心一点就会发现在 jackson-mapper-asl.jar 中，找不到org.springframework.http.converter.json.MappingJacksonHttpMessageConverter 方法，
项目启动时果不其然报错了

```java
Cannot find class [org.springframework.http.converter.json.MappingJacksonHttpMessageConverte‌​‌​r] for bean with name 'mappingJacksonHttpMessageConverter' defined in class path resource [spring-mvc.xml]; 
.....
```

最终在 Stack Overflow 上找到的答案：

> Also MappingJacksonHttpMessageConverter is deprecated in 4.0.0 there is something newer. And you will need to add dependencies for jackson as well to get things working.

原文地址：

- [classnotfoundexception-org-springframework-http-converter-json-mappingjacksonht](http://stackoverflow.com/questions/20969722/classnotfoundexception-org-springframework-http-converter-json-mappingjacksonht)
- [jackson-2-0-with-spring-3-1 +](http://stackoverflow.com/questions/10420040/jackson-2-0-with-spring-3-1/13435703#13435703)

修改后的配置如下：

```xml
<!--避免IE执行AJAX时，返回JSON出现下载文件 -->
<bean id="mappingJacksonHttpMessageConverter"
    class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
    <property name="supportedMediaTypes">
        <list>
            <value>text/html;charset=UTF-8</value>
        </list>
	</property>
</bean>

<!-- jackson版本号 -->
<jackson.version>2.6.0-rc1</jackson.version>

<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>${jackson.version}</version>
</dependency>
    
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-core</artifactId>
    <version>${jackson.version}</version>
</dependency>
```
