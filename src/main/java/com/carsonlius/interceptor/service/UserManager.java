package com.carsonlius.interceptor.service;

public interface UserManager {
     void addUser(String userName);
     void delUser(int userId);
     String findUser(int userId);
}
