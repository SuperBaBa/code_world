package org.jarvis;

import lombok.extern.slf4j.Slf4j;
import org.jarvis.exception.CustomizeDuplicatedKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;

import java.util.List;
import java.util.Map;

/**
 * 本模块通过复写sql-error-codes.xml依赖注入${@link CustomSQLErrorCodesTranslation#setExceptionClass(Class)}
 * 实现自定义异常的抛出
 * author:tennyson date:2020/7/7
 **/
@SpringBootApplication
@Slf4j
public class DataBaseErrorCode implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DataBaseErrorCode.class, args);
    }


    @Override
    public void run(String... args) {
        try {
            jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'a')");
            jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'b')");
            List<Map<String, Object>> result = jdbcTemplate.queryForList("SELECT * FROM FOO");
            result.forEach(map -> log.info("{}", map));

        } catch (CustomizeDuplicatedKeyException e) {
            log.error("occur customized exception", e);

        }

    }
}
