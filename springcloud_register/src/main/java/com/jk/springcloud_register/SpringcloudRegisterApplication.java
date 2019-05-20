package com.jk.springcloud_register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudRegisterApplication.class, args);
    }

}
