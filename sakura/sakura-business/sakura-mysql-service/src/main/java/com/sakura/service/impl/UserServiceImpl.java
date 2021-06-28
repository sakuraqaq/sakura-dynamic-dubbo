package com.sakura.service.impl;

import com.sakura.mapper.UserMapper;
import com.sakura.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : bi
 * @since : 2021年06月24日
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @GlobalTransactional
    @Override
    public String getUser() {

        return "获取用户成功" + "\r\n" + userMapper.selectById(1L);
    }

}
