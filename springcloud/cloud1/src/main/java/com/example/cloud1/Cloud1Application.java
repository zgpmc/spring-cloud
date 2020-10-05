package com.example.cloud1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(value = "com.example.cloud1.dao")
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class Cloud1Application
{

    public static void main(String[] args)
    {
        SpringApplication.run(Cloud1Application.class, args);
    }

}