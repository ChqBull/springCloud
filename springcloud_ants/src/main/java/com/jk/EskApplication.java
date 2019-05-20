package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.jk.mapper")
@EnableTransactionManagement
public class EskApplication {

    public static void main(String[] args) {
        SpringApplication.run(EskApplication.class, args);
    }

}
