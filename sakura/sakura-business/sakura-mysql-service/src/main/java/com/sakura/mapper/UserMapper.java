package com.sakura.mapper;


import com.sakura.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author : bi
 * @since : 2021年06月28日
 */
public interface UserMapper {

    User selectById(@Param("userId")Long userId);
}
