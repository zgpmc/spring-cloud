package com.example.streamcustomer;

import com.example.streamcustomer.server.IPipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamcustomerApplicationTests
{

    @Autowired
    private IPipe iPipe;

    @Test
    public void contextLoads()
    {
        iPipe.messageOutput().send(MessageBuilder.withPayload("消息来了").build());
    }

}
