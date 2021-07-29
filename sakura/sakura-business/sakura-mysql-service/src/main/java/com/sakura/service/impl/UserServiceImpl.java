package com.sakura.service.impl;


import com.sakura.service.UserService;
import lombok.RequiredArgsConstructor;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : bi
 * @since : 2021年06月24日
 */
@DubboService
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    @Override
    public String getUser() {
        return "";
    }

}
