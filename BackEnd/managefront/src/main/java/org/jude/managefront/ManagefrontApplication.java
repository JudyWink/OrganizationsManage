package org.jude.managefront;

//Spring Boot的启动类
// 一定要加@SpringBootApplication

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManagefrontApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagefrontApplication.class, args);
    }

}
