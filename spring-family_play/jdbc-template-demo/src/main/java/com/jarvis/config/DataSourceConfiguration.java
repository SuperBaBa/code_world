package com.jarvis.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 配置多个数据源，并使用不同数据源的链接进行操作
 * author:tennyson date:2020/7/4
 **/
//@Configuration
public class DataSourceConfiguration {


    @Bean
    @ConfigurationProperties(value = "first.datasource")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource firstDataSource(DataSourceProperties firstDataSourceProperties) {
        firstDataSourceProperties.setSqlScriptEncoding(StandardCharsets.UTF_8);
        firstDataSourceProperties.setSchema(Arrays.asList("classpath:schema.sql"));
        firstDataSourceProperties.setData(Arrays.asList("classpath:data.sql"));

        return firstDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public PlatformTransactionManager firstTxManager(DataSource firstDataSource) {
        return new DataSourceTransactionManager(firstDataSource);
    }

    @Bean
    JdbcTemplate firstJdbcTemplate(DataSource firstDataSource) {
        return new JdbcTemplate(firstDataSource);
    }

    @Bean
    @ConfigurationProperties(value = "second.datasource")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource secondDataSource(DataSourceProperties secondDataSourceProperties) {
        secondDataSourceProperties.setSqlScriptEncoding(StandardCharsets.UTF_8);
        return secondDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public PlatformTransactionManager secondTxManager(DataSource secondDataSource) {
        return new DataSourceTransactionManager(secondDataSource);
    }

    @Bean
    JdbcTemplate secondJdbcTemplate(DataSource secondDataSource) {
        return new JdbcTemplate(secondDataSource);
    }
}
