package com.jarvis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 1. 内存数据库初始化，通过resource两资源文件进行数据初始化
 *  + schema 初始化表， data 初始化数据
 * 2. SpringBoot自动配置的DataSource和JdbcTemplate
 *  通过日志可以看出，默认配置的是HikariDataSource
 */
@SpringBootApplication
@RestController
@Slf4j
public class DataSourceDemoApplication implements CommandLineRunner {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DataSourceDemoApplication.class, args);
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello-spring";
    }

    @Override
    public void run(String... args) throws Exception {
        showConnection();
        showData();
    }

    private void showConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection connection = dataSource.getConnection();
        log.info(connection.toString());
        connection.close();
    }

    private void showData() {
        jdbcTemplate.queryForList("SELECT * FROM FOO").forEach(row -> {
            log.info(row.toString());
        });
    }
}
