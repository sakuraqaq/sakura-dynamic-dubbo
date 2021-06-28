package com.sakura.controller;


import com.sakura.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : bi
 * @since : 2021年06月24日
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Reference
    private UserService userService;

    @GetMapping("/logins")
    public String getUser()
    {
        return userService.getUser();
    }


}
