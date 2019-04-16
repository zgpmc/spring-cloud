package com.example.use2.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建时间:2019/04/03
 * 创建人:pmc
 * 描述:
 */
//错误“hystrix dashboard Unable to connect to Command Metric Stream” 如果是使用的springboot 是2.0版本 访问http://localhost:8076/hystrix.stream 需添加如下配置类 否则无法访问
@Configuration
public class Config
{
    @Bean
    public ServletRegistrationBean getServlet()
    {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
