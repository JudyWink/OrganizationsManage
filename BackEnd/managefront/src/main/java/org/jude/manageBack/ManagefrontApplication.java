package org.jude.manageBack;

//Spring Boot的启动类
// 一定要加@SpringBootApplication

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
//Servlet可以直接通过@WebServlet注解自动注册
//Filter可以直接通过@WebFilter注解自动注册
//Listener可以直接通过@WebListener 注解自动注册

@MapperScan("org.jude.manageBack.mapper")
public class ManagefrontApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagefrontApplication.class, args);
    }

}
