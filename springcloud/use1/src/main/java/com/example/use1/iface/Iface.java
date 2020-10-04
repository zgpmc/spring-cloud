package com.example.use1.iface;

import com.example.use1.hystrix.MyHystrixFactory;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 创建时间:2019/03/28
 * 创建人:pmc
 * 描述:
 */

/**
 * @FeignClient 远程调用 value:调用哪个提供者 fallback:熔断器的类 当远程调用失败时 使用熔断器的实现
 */
//此用法以经支持负载均衡
@FeignClient(value = "cloud1", fallbackFactory = MyHystrixFactory.class)
@Component
public interface Iface
{
    /**
     * 提供者的方法 方法名、返回值、参数必须一致，路径为访问提供者的路径
     * mapping路径写提供者的访问路径 远程调用的接口必须写requestparam 否则要么错误要么拿不到参数
     * @param name
     * @return
     */
    @RequestMapping(value = "/test/hello")
    public String hello(@RequestParam(name = "name") String name);

    @RequestMapping(value = "/test/word")
    public String word();

    @RequestMapping(value = "/test/ld/sel")
    public Object getldcode(Object object);
}
