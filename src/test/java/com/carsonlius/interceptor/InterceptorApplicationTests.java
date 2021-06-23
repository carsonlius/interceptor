package com.carsonlius.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.Assert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.carsonlius.interceptor.entity.User;
import com.carsonlius.interceptor.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;

@SpringBootTest
class InterceptorApplicationTests {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testFindById() {
        User user = userMapper.findById(1L);
        System.out.println(user);
    }

    @Test
    void contextLoads() {
    }


    @Test
    public void testSelect() {
        List<User> userList = userMapper.selectList(null);
        userList.stream().forEach(System.out::println);

        Assert.isTrue(5 == userList.stream().count(), null);
    }

    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Tom");
        map.put("age", 28);
        int result = userMapper.deleteByMap(map);
        System.out.println("deleteByMap result:" + result);
    }

    @Test
    public void testDelete() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<Long> list = new LinkedList<>();
//        list.add(5L);
//        list.add(2L);
//        queryWrapper.inSql(true,"id", "5,2");
//        queryWrapper.in(false, "id", list);

//        User user = new User();
//        user.setAge(28);
//        queryWrapper.setEntity(user);
        queryWrapper.eq("id", 1L).or(true,
                i -> i.ge("age", 23).in("name", "BIllie"));

        int result = userMapper.delete(queryWrapper);
        System.out.println("in result:" + result);
    }

    @Test
    public void testDeleteBatchIds() {
        List<Long> list = new LinkedList<>();
        list.add(5L);
        list.add(2L);

        int result = userMapper.deleteBatchIds(list);
        System.out.println("deleteBatchIds result:" + result);
    }

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(33L);
        System.out.println("selectById " + user);
    }

    @Test
    public void testSelectOne() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id", 1);
        User user = userMapper.selectOne(userQueryWrapper);

        System.out.println("user " + user);
    }

    @Test
    public void testSelectCount() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.ge("id", 1);
        int count = userMapper.selectCount(userQueryWrapper);
        System.out.println("count:" + count);
    }


    @Test
    public void testSelectList() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("name,age,email").
                likeLeft("name", "carsonlius");
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println(userList);
    }

    @Test
    public void testSelectPage() {
        Page<User> page = new Page<>(1, 2);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.ge("id", 1);
        userQueryWrapper.orderByDesc("id");

        IPage<User> iPage = userMapper.selectPage(page, userQueryWrapper);
        System.out.println("total results:" + iPage.getTotal());
        System.out.println("total page:" + iPage.getPages());
        System.out.println("current page:" + iPage.getCurrent());
        List<User> userList = iPage.getRecords();
        System.out.println(userList);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("刘森2");
        user.setAge(29);
        int result = userMapper.insert(user);
        System.out.println("insert result:" + result);
        System.out.println("id :" + user.getId());
    }

    @Test
    public void testAllEq() {
        Map<String, Object> where = new HashMap<>();
        where.put("name", "carsonlius");
        where.put("age", 29);
        where.put("email", null);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.allEq(where, false);
        queryWrapper.allEq((x,y)->true, where);
//        queryWrapper.allEq((x,y)-> y!=null, where);



        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }


    @Test
    public void testDeleteAll(){
//        int result = userMapper.delete(null);
        User user = new User();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("id", 1);
        user.setName("test delete2");
       int result =  userMapper.update(user, null);
        System.out.println("delete all result:"+ result);
    }

    @Test
    public void testUpdateById(){
        User user = userMapper.selectById(1L);
        User userUpdate = new User();
        userUpdate.setId(user.getId());
        userUpdate.setName("liusen3");
        userUpdate.setVersion(3);

        int result = userMapper.updateById(userUpdate);
        System.out.println("version updateById result:" + result);
    }
}
