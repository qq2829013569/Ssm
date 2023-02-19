package com.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {GsonAutoConfiguration.class})
@EnableDiscoveryClient
@MapperScan("com.cloud.dao")
public class ServletMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(ServletMain8001.class,args);
    }
}
