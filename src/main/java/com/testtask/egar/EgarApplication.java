package com.testtask.egar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EgarApplication {

    public static void main(String[] args) {
        SpringApplication.run(EgarApplication.class, args);
    }

}
