package com.carsonlius.interceptor.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.carsonlius.interceptor.entity.User;

@DS("master")
public interface UserMapper extends MyBaseMapper<User> {
    User findById(Long id);
}
