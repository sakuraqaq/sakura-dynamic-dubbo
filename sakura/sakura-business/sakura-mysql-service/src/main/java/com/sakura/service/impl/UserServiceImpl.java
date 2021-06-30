package com.sakura.service.impl;

import com.sakura.blog.myblog.farme.wapper.QueryWrapper;
import com.sakura.entity.User;
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
        return "获取用户成功" + "\r\n" + userMapper.selectOne(new QueryWrapper<User>().eq(User::getUserId,1L));
    }

}
