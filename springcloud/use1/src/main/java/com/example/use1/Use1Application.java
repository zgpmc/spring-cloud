package com.example.use1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableDiscoveryClient
//用于启动Fegin功能
@EnableFeignClients
//单个应用监测
@EnableHystrixDashboard
@EnableCircuitBreaker
@SpringBootApplication
public class Use1Application {
    public static void main(String[] args) {
        SpringApplication.run(Use1Application.class, args);
    }
}
