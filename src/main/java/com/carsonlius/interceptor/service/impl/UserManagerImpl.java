package com.carsonlius.interceptor.service.impl;

import com.carsonlius.interceptor.service.UserManager;

public class UserManagerImpl implements UserManager {
    @Override
    public void addUser(String userName) {
        System.out.println("UserManagerImpl.addUser");
    }

    @Override
    public void delUser(int userId) {
        System.out.println("UserManagerImpl.delUser");
    }

    @Override
    public String findUser(int userId) {
        System.out.println("UserManagerImpl.findUser");
        return "carsonlius";
    }
}
