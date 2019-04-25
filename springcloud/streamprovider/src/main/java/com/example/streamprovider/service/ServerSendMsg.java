package com.example.streamprovider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * 创建时间:2019/04/25
 * 创建人:pmc
 * 描述:
 */
@Service
@EnableBinding(value = {IPipe.class})
public class ServerSendMsg
{
    @Autowired
    IPipe iPipe;

    public String sendMsg(String msg)
    {
        System.out.println("要发的消息是:" + msg);
        iPipe.messageOutput().send(MessageBuilder.withPayload(msg).build());
        return "发送完毕！";
    }
}
