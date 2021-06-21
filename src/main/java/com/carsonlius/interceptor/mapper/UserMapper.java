package com.carsonlius.interceptor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.carsonlius.interceptor.entity.User;

public interface UserMapper extends BaseMapper<User> {
    User findById(Long id);
}
