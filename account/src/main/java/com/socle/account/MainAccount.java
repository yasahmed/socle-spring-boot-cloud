package com.socle.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value="com.socle.*")
@EnableEurekaClient

public class MainAccount {
    public static void main(String[] args) {
        SpringApplication.run(MainAccount.class, args);
    }
}
