package com.carsonlius.interceptor;

import com.baomidou.mybatisplus.extension.api.Assert;
import com.carsonlius.interceptor.entity.User;
import com.carsonlius.interceptor.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class InterceptorApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }


    @Test
    public void testSelect(){
        List<User> userList = userMapper.selectList(null);
        userList.stream().forEach(System.out::println);

        Assert.isTrue(5 == userList.stream().count(),null );
    }

}
