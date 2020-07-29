package com.jarvis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * author:marcus date:2020/7/16
 **/

@ConfigurationProperties(prefix = "prefixname")
@Configuration
@PropertySource(value = {"classpath:person.properties"})

//@PropertySource(value = {"classpath:person.yml"})
//@ImportResource(locations = {"classpath*:person.properties"})
public class LoadPropertyConfiguration {
    private String second;
    private String first = "data.sql";

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

   /* @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
//        yaml.setResources(new ClassPathResource("myconfig.yml"));
        yaml.setResources(new FileSystemResource("E:\\workspace\\code_world\\spring-family_play\\datasource-demo\\src\\main\\resources\\person.yml"));
        configurer.setProperties(yaml.getObject());
        return configurer;
    }*/
}
