package org.jarvis.ssl;

import org.jarvis.ssl.config.LoadPropertyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class SSLPlayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SSLPlayApplication.class, args);
    }
}
