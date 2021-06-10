package com.carsonlius.interceptor.service.impl;

import com.carsonlius.interceptor.service.Consume;

public class ConsumeImpl implements Consume {
    @Override
    public String buy(String product) {
        System.out.println("每天都会消费" + product);

        return "每天都要消费/交税" + product;
    }
}
