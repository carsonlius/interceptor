package com.carsonlius.interceptor.filters;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Order(value = 1)
@Configuration
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("*** LoginFilter   doFilter before***");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        System.out.println(request.getSession());



        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("*** LoginFilter   doFilter after***");
    }
}
