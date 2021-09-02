package com.sakura.mapper;

import com.sakura.enity.SakuraOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper {


    SakuraOrder getOrderById(@Param("id") Long id, @Param("projectId") Long projectId);

    void insert(SakuraOrder sakuraOrder);

}
