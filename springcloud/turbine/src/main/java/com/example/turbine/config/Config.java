package com.example.turbine.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建时间:2019/04/04
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
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(hystrixMetricsStreamServlet);
        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }
}
