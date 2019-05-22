package com.jk.util;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient//可以往注册中心进行注册
@EnableFeignClients//可以调用注册中心的其他服务
@MapperScan("com.jk.mapper")/*扫描持久层*/
public class UserClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserClientApplication.class, args);
    }

}
