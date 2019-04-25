package com.example.streamprovider;

import com.example.streamprovider.service.IPipe;
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
@EnableBinding(value = {Processor.class, IPipe.class})
public class StreamproviderApplicationTests
{
    @Autowired
    private Processor processor;
    @Autowired
    private MessageCollector messageCollector;

    @Autowired
    private IPipe iPipe;

    @Test
    public void contextLoads()
    {
        //processor.input().send(MessageBuilder.withPayload("6666").build());
        //Object payload = messageCollector.forChannel(processor.output()).poll().getPayload();
        iPipe.messageOutput().send(MessageBuilder.withPayload("给我返回订单").build());
        /*System.out.println("processor" + payload.toString());
        iPipe.messageInput().send(MessageBuilder.withPayload("777").build());
        payload = messageCollector.forChannel(iPipe.messageOutput()).poll().getPayload();
        System.out.println(payload.toString() + "->messageOutput");
        iPipe.messageInput1().send(MessageBuilder.withPayload("88").build());
        payload = messageCollector.forChannel(iPipe.messageOutput2()).poll().getPayload();
        System.out.println(payload.toString() + "->messageOutput2");*/
    }

}
