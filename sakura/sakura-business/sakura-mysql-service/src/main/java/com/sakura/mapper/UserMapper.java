package com.sakura.mapper;


import com.sakura.blog.myblog.farme.base.BaseMapper;
import com.sakura.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author : bi
 * @since : 2021年06月28日
 */
public interface UserMapper extends BaseMapper<User, Long> {

    User selectById(@Param("userId")Long userId);
}
