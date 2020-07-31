package org.jarvis.ssl;

import org.jarvis.ssl.config.LoadPropertyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SslPlayApplication implements CommandLineRunner {
    @Autowired
    private LoadPropertyConfiguration configuration;

    public static void main(String[] args) {
        SpringApplication.run(SslPlayApplication.class, args);
    }

    @RequestMapping(value = "/loadfile")
    public String loadfile() {
        return configuration.getFirst();
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
