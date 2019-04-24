package com.example.streamprovider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableBinding(value = {Processor.class})
public class StreamproviderApplicationTests
{
    @Autowired
    private Processor processor;
    @Autowired
    private MessageCollector messageCollector;

    @Test
    public void contextLoads()
    {
        //messageChannel.send(MessageBuilder.withPayload("发条消息试试").build());
        //source.output().send(MessageBuilder.withPayload("发条消息试试").build());
        processor.input().send(MessageBuilder.withPayload("6666").build());
        Object payload = messageCollector.forChannel(processor.output()).poll().getPayload();
        System.out.println(payload.toString());
    }

}
