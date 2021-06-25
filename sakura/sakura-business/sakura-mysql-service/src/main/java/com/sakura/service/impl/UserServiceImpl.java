package com.sakura.service.impl;

import com.sakura.service.UserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author : bi
 * @since : 2021年06月24日
 */
@Service
public class UserServiceImpl  implements UserService {


    @Override
    public String getUser() {
        return "获取用户成功";
    }
}
