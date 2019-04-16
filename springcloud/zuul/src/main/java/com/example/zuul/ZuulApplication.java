package com.example.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//启动类添加@EnableZuulProxy，支持网关路由。
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ZuulApplication.class, args);
    }

}
