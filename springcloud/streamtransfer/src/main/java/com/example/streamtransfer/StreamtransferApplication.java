package com.example.streamtransfer;

import com.example.streamtransfer.server.IPipe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding(value = {IPipe.class})
public class StreamtransferApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(StreamtransferApplication.class, args);
    }

    @StreamListener(IPipe.INPUTT)
    @SendTo(IPipe.OUTPUTT)
    public Object msgT(Object object)
    {
        System.out.println("消息经过中转！");
        return object;
    }
}
