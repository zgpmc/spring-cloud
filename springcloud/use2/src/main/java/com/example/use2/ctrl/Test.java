package com.example.use2.ctrl;

import com.example.use2.iface.Iface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间:2019/04/02
 * 创建人:pmc
 * 描述:
 */
@RestController
@RequestMapping(value = "/test")
public class Test
{
    @Autowired()
    Iface iface;

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "")
    public String test()
    {
        return "use2:" + port;
    }

    @RequestMapping(value = "/hello/{name}")
    public String hello(@PathVariable(name = "name") String name)
    {
        return iface.hello(name);
    }
}
