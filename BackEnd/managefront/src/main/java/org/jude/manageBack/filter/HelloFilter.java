package org.jude.manageBack.filter;


import javax.servlet.*;
import java.io.IOException;

public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("enter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("leave");
    }

    @Override
    public void destroy() {

    }
}
