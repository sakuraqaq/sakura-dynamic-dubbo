package com.sakura.entity;

import com.sakura.blog.myblog.farme.annotation.Column;
import com.sakura.blog.myblog.farme.annotation.Table;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : bi
 * @since : 2021年06月28日
 */
@Data
@Table(value = "user", auto = "auto")
public class User implements Serializable {


    @Column(columnName = "user_id", isPrimaryKey = true, isNull = false, jdbcType = JdbcType.BIGINT,length = 32, comment = "用户id")
    private Long userId;

    @Column(columnName = "user_name", jdbcType = JdbcType.VARCHAR,length = 32, comment = "用户名")
    private String userName;

    @Column(columnName = "age", jdbcType = JdbcType.BIGINT, comment = "年龄")
    private Integer age;

    @Column(columnName = "create_date", jdbcType = JdbcType.DATE)
    private Date createDate;

    @Column(columnName = "count", jdbcType = JdbcType.BIGINT)
    private Integer count;

    @Column(columnName = "phone_number", jdbcType = JdbcType.VARCHAR, length = 32, comment = "手机号")
    private String phoneNumber;

    @Column(columnName = "pass_word", jdbcType = JdbcType.VARCHAR, length = 32, comment = "密码")
    private String password;
}