package com.jarvis;

import com.jarvis.service.CoffeeOrderService;
import com.jarvis.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 本模块使用spring jpa实现java持久化，依然采用H2内存数据库，hibernate进行表生成
 * author:tennyson date:2020/7/5
 **/
@SpringBootApplication
@EnableJpaRepositories
public class JPADemoApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(JPADemoApplication.class, args);
    }
    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private CoffeeOrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        coffeeService.initCoffee();
        orderService.initCoffeeOrder();
        orderService.findOrders();
    }
}
