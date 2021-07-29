package com.sakura.controller;


import com.sakura.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;

/**
 * @author : bi
 * @since : 2021年06月24日
 */
@Controller
public class LoginController {

    @DubboReference
    private UserService userService;

    public String getUser()
    {
        return userService.getUser();
    }


}
