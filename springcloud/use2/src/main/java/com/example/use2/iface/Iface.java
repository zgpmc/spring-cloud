package com.example.use2.iface;

import com.example.use2.hystrix.MyHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 创建时间:2019/04/02
 * 创建人:pmc
 * 描述:
 */
@Component
@FeignClient(name = "cloud1", fallback = MyHystrix.class)
public interface Iface
{
    @RequestMapping(value = "/test/hello")
    public String hello(@RequestParam(name = "name") String name);
}
