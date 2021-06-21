package com.carsonlius.interceptor.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@TableName("user")
@Data
public class UserActiveRecord  extends Model<UserActiveRecord> {
    private Long id;

    private String name;

    @TableField(select = false)
    private Integer age;

    private String email;

    private String userRemark;

    @Override
    public String toString() {
        return "UserActiveRecord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", userRemark='" + userRemark + '\'' +
                '}';
    }
}
