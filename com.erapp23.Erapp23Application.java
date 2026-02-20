package com.erapp23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "com.erapp23")
@EnableJpaRepositories(basePackages = "com.erapp23.repository")
@EntityScan(basePackages = "com.erapp23.entity")
public class Erapp23Application {

    public static void main(String[] args) {
        SpringApplication.run(Erapp23Application.class, args);
    }
}
