package org.jude.manageBack.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //允许跨域请求
//        String []  allowDomain= {"http://localhost:8020","http://127.0.0.1:8020"};
//        Set<String> allowedOrigins= new HashSet<String>(Arrays.asList(allowDomain));
//        String originHeader=((HttpServletRequest) servletRequest).getHeader("Origin");
//        if (allowedOrigins.contains(originHeader)) {
//            response.setHeader("Access-Control-Allow-Origin", originHeader);
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type,Token,Authorization,ybg");

            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("跨域请求通过");
//        }
    }

    @Override
    public void destroy() {
        System.out.println("销毁filter");
    }
}
