package com.carsonlius.interceptor.injectors;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.methods.*;
import org.apache.ibatis.mapping.SqlSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MySqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod>  methodList = super.getMethodList(mapperClass);
        methodList.add(new FindAll());
        return methodList;
    }
}
