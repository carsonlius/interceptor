package com.carsonlius.interceptor.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user")
public class User {
    @TableId(value = "user_id")
    private Long id;

    @TableField(value = "username")
    private String name;
    @TableField(value = "status")
    private Integer age;

    @TableField(value = "password")
    private String email;
}
