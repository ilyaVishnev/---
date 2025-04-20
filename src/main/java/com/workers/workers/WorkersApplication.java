package com.workers.workers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class WorkersApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkersApplication.class, args);
    }

}
