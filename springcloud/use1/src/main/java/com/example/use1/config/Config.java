package com.example.use1.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 创建时间:2019/04/04
 * 创建人:pmc
 * 描述:
 */
//错误“hystrix dashboard Unable to connect to Command Metric Stream” 如果是使用的springboot 是2.0版本 访问http://localhost:8076/hystrix.stream 需添加如下配置类 否则无法访问
@Configuration
public class Config {
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(hystrixMetricsStreamServlet);
        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }

    /**
     * 消费者调用中心服务第2中方式resttem+ribion 需要在config类中声明一个RestTemplate的实例 能请求 并且使用LoadBalanced注解用于支持restt url写成中心注册的服务名识别 不分大小写 且有负载均衡机制
     *
     * @return RestTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
