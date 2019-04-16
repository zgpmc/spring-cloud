package com.example.use1.ctrl;

import com.example.use1.iface.Iface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间:2019/03/28
 * 创建人:pmc
 * 描述:
 */
@RestController
@EnableFeignClients(value = "com.example.cloud2.ctrl")
@RequestMapping(value = "/test")
public class Test
{
    @Autowired
    Iface iface;

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "")
    public String test()
    {
        return "use1服务使用者:端口" + port;
    }

    @RequestMapping(value = "/hello/{name}")
    public String testuse(@PathVariable(name = "name") String name)
    {
        return iface.hello(name);
    }

    @RequestMapping(value = "/word")
    public String word()
    {
        return iface.word();
    }

    @RequestMapping(value = "/ld")
    public Object getld(@RequestBody(required = false) Object object)
    {
        Object object1 = iface.getldcode(object);
        return object1;
    }
}
