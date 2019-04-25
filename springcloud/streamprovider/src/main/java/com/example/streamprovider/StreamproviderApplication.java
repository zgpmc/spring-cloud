package com.example.streamprovider;

import com.example.streamprovider.mode.Order;
import com.example.streamprovider.service.IPipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

/*Spring Cloud Stream已经为我们提供了三个绑定消息通道的默认实现
Sink：通过指定消费消息的目标来标识消息使用者的约定。
Source：与Sink相反，用于标识消息生产者的约定。
Processor：集成了Sink和Source的作用，标识消息生产者和使用者*/
@SpringBootApplication
//@EnableBinding({Processor.class, Sink.class, Source.class}) 使用系统自有通道 sink:input source：output
@EnableBinding({Processor.class, IPipe.class}) //使用自定义通道
public class StreamproviderApplication
{
    @Autowired
    private IPipe iPipe;

    public static void main(String[] args)
    {
        SpringApplication.run(StreamproviderApplication.class, args);
    }

    @StreamListener(IPipe.MESSAGE_INPUT)
    public void getOrder(Order order)
    {
        System.out.println("收到消费反馈");
        System.out.println("order:" + order.getOrderNum() + "->" + order.getType() + "->" + order.getNum() + "->" + order.getCreateAt());
    }

   /* @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public String msg(String msg)
    {
        System.out.println("收到消息：" + msg);
        return msg;
    }

    @StreamListener(IPipe.MESSAGE_INPUT)
    @SendTo(IPipe.MESSAGE_OUTPUT)
    public String imsg(String msg)
    {
        System.out.println("自定义通道收到消息：" + msg);
        String mg = "";
        if (msg.length() > 3)
        {
            mg = "msg1:";
            iPipe.messageOutput().send(sendMsg(mg + msg));
        } else
        {
            mg = "msg2:";
            iPipe.messageOutput2().send(sendMsg(mg + msg));
        }
        return (mg + msg);
    }

    @StreamListener(IPipe.MESSAGE_INPUT1)
    @SendTo(IPipe.MESSAGE_OUTPUT_2)
    public String imsg1(String msg)
    {
        System.out.println("第二消费者收到消息:" + msg);`
        return "第二消费者收到消息:" + msg + "->消费1";
    }*/

    private final <T> Message<T> sendMsg(T t)
    {
        return MessageBuilder.withPayload(t).build();
    }
}
