package com.example.cloudserver.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 创建时间:2019/03/22
 * 创建人:pmc
 * 描述:
 */
@RestController
@RequestMapping(value = "/test")
public class Test
{
   /* @Value("${server.port}")
    String port;
    @Value("${eureka.instance.hostname}")
    String host;*/

    @RequestMapping(value = "")
    public String test()
    {
        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
        String res = "服务中心互相注册:" + request.getLocalAddr() + request.getServerPort();//host + ":" + port;
        System.out.println(res);
        return res;
    }
}
