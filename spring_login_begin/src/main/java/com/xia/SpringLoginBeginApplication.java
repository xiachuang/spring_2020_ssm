package com.xia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringLoginBeginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLoginBeginApplication.class, args);
    }

}
