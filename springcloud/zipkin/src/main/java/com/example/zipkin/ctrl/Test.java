package com.example.zipkin.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间:2019/04/19
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
    public String tes()
    {
        return "zipkin链路追踪提供服务。端口:" + port;
    }
}
