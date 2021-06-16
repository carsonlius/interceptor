package com.carsonlius.interceptor.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class User {
    private Long id;

    private String name;
    private Integer age;

    private String email;
}
