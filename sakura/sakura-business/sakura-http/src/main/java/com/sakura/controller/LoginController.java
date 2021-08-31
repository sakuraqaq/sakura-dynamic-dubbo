package com.sakura.controller;


import com.sakura.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : bi
 * @since : 2021年06月24日
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @DubboReference
    private UserService userService;

    @GetMapping("/users")
    public String getUser()
    {
        userService.getUser();
        return "nihao";
    }


}
