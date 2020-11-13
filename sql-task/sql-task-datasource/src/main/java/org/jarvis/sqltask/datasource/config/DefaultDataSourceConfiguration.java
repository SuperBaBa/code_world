package org.jarvis.sqltask.datasource.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.config.SortedResourcesFactoryBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/**
 * 默认数据源配置，也就是配置在了配置文件中的数据源
 * 此处数据源仅限于重启时加载
 *
 * @author marcus
 * @date 2020/11/13-16:46
 */
@Configuration
public class DefaultDataSourceConfiguration {


    @Bean
    @ConfigurationProperties(value = "first.datasource")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 因为关闭了{@link DataSourceAutoConfiguration} 导致无法自动执行schema.sql/data.sql
     * 因此在自定义{@link DataSource}实例化时，同时获取资源，并执行sql
     *
     * @return
     */
    @Bean(name = "firstDataSource")
    @Primary
    public DataSource firstDataSource() {
        DataSourceProperties firstDataSourceProperties = firstDataSourceProperties();
        firstDataSourceProperties.setSqlScriptEncoding(StandardCharsets.UTF_8);
        firstDataSourceProperties.setSchema(Arrays.asList("classpath:schema.sql"));
        firstDataSourceProperties.setData(Arrays.asList("classpath:data.sql"));
        DataSource dataSource = firstDataSourceProperties.initializeDataSourceBuilder().build();
        {
            ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
            try {
                SortedResourcesFactoryBean factory = new SortedResourcesFactoryBean(
                        Collections.singletonList("classpath:schema.sql"));
                factory.afterPropertiesSet();
                populator.addScripts(Objects.requireNonNull(factory.getObject()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            DatabasePopulatorUtils.execute(populator, dataSource);
        }
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager firstTxManager() {
        return new DataSourceTransactionManager(firstDataSource());
    }

    @Bean(name = "firstJdbcTemplate")
    @Primary
    JdbcTemplate firstJdbcTemplate() {
        return new JdbcTemplate(firstDataSource());
    }

    @Bean
    @ConfigurationProperties(value = "second.datasource")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource secondDataSource() {
        DataSourceProperties secondDataSourceProperties = secondDataSourceProperties();
        secondDataSourceProperties.setSqlScriptEncoding(StandardCharsets.UTF_8);
        return secondDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public PlatformTransactionManager secondTxManager() {
        return new DataSourceTransactionManager(secondDataSource());
    }

    @Bean(value = "secondJdbcTemplate")
    JdbcTemplate secondJdbcTemplate() {
        return new JdbcTemplate(secondDataSource());
    }

}
