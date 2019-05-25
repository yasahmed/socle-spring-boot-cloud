package com.socle.account;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;

@SpringBootApplication
@ComponentScan(value="com.socle.*")
@EnableFeignClients(basePackages = {"com.socle.account"})

public class MainAccount {

    public static void main(String[] args) {
        SpringApplication.run(MainAccount.class, args);
    }
}
