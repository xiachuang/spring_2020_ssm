package com.xia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringEurekaServer7001Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringEurekaServer7001Application.class, args);
    }
}
