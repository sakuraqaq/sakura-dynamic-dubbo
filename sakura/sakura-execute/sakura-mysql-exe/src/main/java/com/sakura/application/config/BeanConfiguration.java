package com.sakura.application.config;

import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator getIdGenerator(){
        return new CommonSelfIdGenerator();
    }
}
