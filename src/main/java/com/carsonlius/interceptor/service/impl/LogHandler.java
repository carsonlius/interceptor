package com.carsonlius.interceptor.service.impl;

import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Service
public class LogHandler implements InvocationHandler {
    private Object targetObject;

    public Object newInstance(Object targetObject){
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(), this.targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("原对象处理before日志");
        Object response = method.invoke(targetObject, args);
        System.out.println("原对象处理after日志");

        return response;
    }
}
