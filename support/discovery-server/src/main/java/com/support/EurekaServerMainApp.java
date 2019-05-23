package com.support;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMainApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMainApp.class, args);
    }
}
