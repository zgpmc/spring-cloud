package com.example.use2.hystrix;

import com.example.use2.iface.Iface;
import org.springframework.stereotype.Component;

/**
 * 创建时间:2019/04/03
 * 创建人:pmc
 * 描述:
 */
@Component
public class MyHystrix implements Iface
{
    @Override
    public String hello(String name)
    {
        return "use2远程调用hello失败!";
    }
}
