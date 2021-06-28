package com.sakura.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author : bi
 * @since : 2021年06月28日
 */
@Data
public class User {



    private Long userId;

    private String userName;

    private Integer age;

    private Date createDate;

    private Integer count;


    private String phoneNumber;

    private String password;
}
