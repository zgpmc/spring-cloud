package com.example.streamprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

/*Spring Cloud Stream已经为我们提供了三个绑定消息通道的默认实现
Sink：通过指定消费消息的目标来标识消息使用者的约定。
Source：与Sink相反，用于标识消息生产者的约定。
Processor：集成了Sink和Source的作用，标识消息生产者和使用者*/
@SpringBootApplication
//@EnableBinding({Processor.class, Sink.class, Source.class}) 使用系统自有通道 sink:input source：output
@EnableBinding({Processor.class}) //使用自定义通道
public class StreamproviderApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(StreamproviderApplication.class, args);
    }

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public String msg(String msg)
    {
        System.out.println("收到消息：" + msg);
        return msg;
    }
}
