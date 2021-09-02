package com.sakura.mapper;

import com.sakura.enity.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaperMapper {

    Paper getUrl(@Param("id")Long id);
}
