package com.carsonlius.interceptor.entity;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class User {
    private Long id;

    private String name;

    @TableField(select = false)
    private Integer age;

    private String email;

    private String userRemark;

    @Version
    private Integer version;
}
