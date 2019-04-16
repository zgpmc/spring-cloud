package com.example.cloud2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "com.example.cloud2")
@MapperScan(value = "com.example.cloud2.dao")
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class Cloud2Application
{

    public static void main(String[] args)
    {
        SpringApplication.run(Cloud2Application.class, args);
    }

}