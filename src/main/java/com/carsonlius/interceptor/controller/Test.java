package com.carsonlius.interceptor.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.carsonlius.interceptor.entity.User;
import com.carsonlius.interceptor.mapper.UserMapper;
import com.carsonlius.interceptor.service.Consume;
import com.carsonlius.interceptor.service.UserManager;
import com.carsonlius.interceptor.service.impl.ConsumeImpl;
import com.carsonlius.interceptor.service.impl.LogHandler;
import com.carsonlius.interceptor.service.impl.UserManagerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;
import java.util.function.Supplier;

@Slf4j
@RestController
public class Test {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LogHandler logHandler;

    @GetMapping("/hello")
    public Object sayHello(){
        Map<String,Object> response= new HashMap<>();
        response.put("status", 0);
        response.put("message", "hello world");

        return response;
    }

    @GetMapping("/test")
    public Object test(){
        System.out.println("-- select all methods test --");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("id", 1);

        List<User> userList = userMapper.selectList(queryWrapper);
        userList.stream().forEach(System.out::println);
        return userList;
    }

    public static void main(String[] args) {

    }
    static class NatualSupplier implements Supplier<Integer> {
        int n =0;
        @Override
        public Integer get() {
            return n++;
        }
    }
}
