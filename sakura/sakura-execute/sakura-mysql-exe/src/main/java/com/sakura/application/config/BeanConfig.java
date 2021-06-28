package com.sakura.application.config;

import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author : bi
 * @since : 2021年06月28日
 */
@Configuration
public class BeanConfig {


    public DataSourceProxy dataSourceProxy(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }


    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner("sakura-dynamic-dubbo","sakura_group");
    }
}
