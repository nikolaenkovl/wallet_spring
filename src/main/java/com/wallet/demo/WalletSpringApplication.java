package com.wallet.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.wallet.repository")
public class WalletSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletSpringApplication.class, args);
    }
}