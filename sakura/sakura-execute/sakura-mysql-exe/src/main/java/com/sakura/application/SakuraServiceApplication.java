package com.sakura.application;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author : bi
 * @since : 2021年06月24日
 */
@EnableDubbo
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
@ComponentScan("com.sakura.*")
@MapperScan("com.sakura.mapper")
public class SakuraServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SakuraServiceApplication.class, args);
    }
}
