package com.example.configclient2.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间:2019/04/09
 * 创建人:pmc
 * 描述:
 */
@RestController
@RefreshScope//使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中
@RequestMapping(value = "test/")
public class Test
{
    @Value("${hello}")
    String hello;

    @RequestMapping(value = "")
    public String getHello()
    {
        return "client2获取的配置hello值为:" + hello;
    }
}
