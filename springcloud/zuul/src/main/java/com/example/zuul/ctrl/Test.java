package com.example.zuul.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间:2019/03/28
 * 创建人:pmc
 * 描述:
 */
@RestController
@RequestMapping(value = "/test")
public class Test
{

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "")
    public String test()
    {
        return "zuul路由处理:端口" + port;
    }

    @RequestMapping(value = "/hello")
    public String test2(String name)
    {
        return "zuul路由处理:端口" + port + "，hello测试:name:" + name;
    }

    @RequestMapping(value = "/err")
    public String test1()
    {
        return "zuul路由处理:端口" + port + "，重定向错误页";
    }
}
