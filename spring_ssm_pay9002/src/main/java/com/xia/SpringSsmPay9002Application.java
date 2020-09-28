package com.xia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
public class SpringSsmPay9002Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSsmPay9002Application.class, args);
    }

}
