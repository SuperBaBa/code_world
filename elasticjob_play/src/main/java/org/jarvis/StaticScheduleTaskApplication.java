package org.jarvis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * author:tennyson date:2020/6/15
 **/
@EnableScheduling
@SpringBootApplication
public class StaticScheduleTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(StaticScheduleTaskApplication.class, args);
    }
}
