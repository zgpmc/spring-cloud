package com.example.cloud2.ctrl;

import com.example.cloud2.model.LDCODE;
import com.example.cloud2.server.impl.ImplILdCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间:2019/03/22
 * 创建人:pmc
 * 描述:
 */
@RestController
@RequestMapping(value = "/test")
public class Test
{
    @Value("${server.port}")
    String port;
    @Autowired
    ImplILdCode implILdCode;

    @RequestMapping(value = "")
    public String test()
    {
        String res = "cloud2提供服务成功！port:" + port;
        System.out.println(res);
        return res;
    }

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(name = "name") String name)
    {
        return "cloud2.hello提供服务:你好！" + name + ",最近ok不？";
    }

    @RequestMapping(value = "/word")
    public String word()
    {
        return "cloud2.word提供服务:你好！";
    }

    @RequestMapping(value = "/ld/add")
    public Object addLdcode(@RequestBody LDCODE ldcode)
    {
        return implILdCode.add(ldcode);
    }

    @RequestMapping(value = "/ld/sel")
    public Object getldcode(@RequestBody(required = false) LDCODE ldcode)
    {
        return implILdCode.selectByCodeAndCodenameAndCodetype(ldcode);
    }
}