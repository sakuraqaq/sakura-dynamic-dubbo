package com.sakura.service;


import org.apache.dubbo.config.annotation.DubboService;

@DubboService(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService{


    @Override
    public String getUser() {
        System.out.println("getUSer()");
        return "user";
    }
}
