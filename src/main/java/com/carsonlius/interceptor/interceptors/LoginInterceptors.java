package com.carsonlius.interceptor.interceptors;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("--- LoginInterceptors preHandle ---");
        System.out.println("Request URL:" + request.getRequestURL());
        System.out.println("Start Time:" + startTime);
        request.setAttribute("startTime", startTime);
        System.out.println(request.getParameter("name"));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(" --- LoginInterceptors postHandle ---");
        System.out.println("Request URL:" + request.getRequestURL());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();
        System.out.println("--- LoginInterceptors afterCompletion ---");
        System.out.println("Request URL:" + request.getRequestURL());
        System.out.println("end time :" +  endTime);
        long startTime = (long)request.getAttribute("startTime");

        System.out.println("tokenTime:" + (endTime-startTime));
    }
}
