package com.example.zuul;

import com.example.zuul.extend.CheckFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

//启动类添加@EnableZuulProxy，支持网关路由。
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ZuulApplication.class, args);
    }

    //增加自定义filter bean
    @Bean
    public CheckFilter checkFilter()
    {
        return new CheckFilter();
    }

    // @Bean
    // public WebClient webClient(){
    //     return
    // }
}
