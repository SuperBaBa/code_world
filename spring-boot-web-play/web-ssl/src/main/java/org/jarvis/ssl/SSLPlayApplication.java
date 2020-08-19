package org.jarvis.ssl;

import org.edwin.annotation.EnableAspectLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@EnableAspectLog
public class SSLPlayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SSLPlayApplication.class, args);
    }
}
