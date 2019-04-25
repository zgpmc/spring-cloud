package com.example.streamcustomer;

import com.example.streamcustomer.mode.Order;
import com.example.streamcustomer.server.IPipe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(value = {Sink.class, IPipe.class})
@SpringBootApplication
public class StreamcustomerApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(StreamcustomerApplication.class, args);
    }

    @StreamListener(IPipe.MESSAGE_INPUT)
    @SendTo(IPipe.MESSAGE_OUTPUT)
    public Order input(String msg)
    {
        System.out.println(msg);
        Order order = new Order("001", "鞋", 10);
        return order;
    }

    @StreamListener(Sink.INPUT)
    public void jsmsg(Object msg)
    {
        System.out.println(msg);
    }

}
