package com.carsonlius.interceptor.config;

import com.carsonlius.interceptor.filters.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

//@Configuration
public class FilterConfig {
    @Bean
    Filter loginFilter(){
        return new LoginFilter();
    }

    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilterFilterRegistrationBean(){
        FilterRegistrationBean<LoginFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter((LoginFilter) loginFilter());
        filterFilterRegistrationBean.addUrlPatterns("/*");
        //filterRegistrationBean.setOrder();多个filter的时候order的数值越小 则优先级越高

        return filterFilterRegistrationBean;
    }
}
