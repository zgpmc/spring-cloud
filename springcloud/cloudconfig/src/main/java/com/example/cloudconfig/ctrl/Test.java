package com.example.cloudconfig.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间:2019/03/25
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
        String res = "注册服务配置成功！port:" + port;
        System.out.println(res);
        return res;
    }
}
