package org.jude.manageBack.config;

import org.jude.manageBack.listener.HelloListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Listener配置类
@Configuration
public class ListenerConfig {

    @Bean
    public ServletListenerRegistrationBean getServletListenerRegistrationBean(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean(new HelloListener());
        return bean;
    }
}
