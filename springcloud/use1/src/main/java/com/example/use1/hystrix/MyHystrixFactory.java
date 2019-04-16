package com.example.use1.hystrix;

import com.example.use1.iface.Iface;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 创建时间:2019/04/03
 * 创建人:pmc
 * 描述:
 */
//两个类2选一
@Component
public class MyHystrixFactory implements FallbackFactory<Iface>
{
    @Override
    public Iface create(Throwable cause)
    {
        return new Iface()
        {
            @Override
            public String hello(String name)
            {
                return "use1远程访问hello失败！使用熔断器:" + cause.getMessage();
            }

            @Override
            public String word()
            {
                return "use1远程访问word失败！使用熔断器:" + cause.getMessage();
            }

            @Override
            public Object getldcode(Object object)
            {
                return "use1远程访问getldcode失败！使用熔断器:" + cause.getMessage();
            }
        };
    }
}


@Component
class MyHystrix implements Iface
{
    /**
     * 提供者的方法 方法名、返回值、参数必须一致，路径为访问提供者的路径
     *
     * @param name
     * @return
     */
    @Override
    public String hello(String name)
    {
        return "use1远程访问hello失败！";
    }

    @Override
    public String word()
    {
        return "use1远程访问word失败！";
    }

    @Override
    public Object getldcode(Object object)
    {
        return "use1远程访问getldcode失败！";
    }
}