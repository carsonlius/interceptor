package com.carsonlius.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.Assert;
import com.carsonlius.interceptor.entity.User;
import com.carsonlius.interceptor.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testDeleteByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Tom");
        map.put("age", 28);
        int result = userMapper.deleteByMap(map);
        System.out.println("deleteByMap result:" + result);
    }

    @Test
    public void testDelete(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<Long> list = new LinkedList<>();
//        list.add(5L);
//        list.add(2L);
//        queryWrapper.inSql(true,"id", "5,2");
//        queryWrapper.in(false, "id", list);

//        User user = new User();
//        user.setAge(28);
//        queryWrapper.setEntity(user);
        queryWrapper.eq("id",1L).or(true,
                i -> i.ge("age", 23).in("name","BIllie"));

        int result = userMapper.delete(queryWrapper);
        System.out.println("in result:" + result);
    }

    @Test
    public void testDeleteBatchIds(){
        List<Long> list = new LinkedList<>();
        list.add(5L);
        list.add(2L);

        int result = userMapper.deleteBatchIds(list);
        System.out.println("deleteBatchIds result:" + result);
    }

    @Test
    public void testSelectById(){
        User user = userMapper.selectById(33L);
        System.out.println("selectById "+ user);
    }

    @Test
    public void testSelectOne(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.ge("id", 1);
        User user = userMapper.selectOne(userQueryWrapper);

        System.out.println("user " + user);
    }

    @Test
    public void testSelectCount(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.ge("id", 1);
        int count = userMapper.selectCount(userQueryWrapper);
        System.out.println("count:" + count);
    }

}
