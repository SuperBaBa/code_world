package com.jarvis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author:marcus date:2020/7/9
 **/
//@ImportResource(locations = "classpath:*.xml")
@SpringBootApplication
public class LogbackDemo {
    public static void main(String[] args) {
        SpringApplication.run(LogbackDemo.class, args);
    }
}
