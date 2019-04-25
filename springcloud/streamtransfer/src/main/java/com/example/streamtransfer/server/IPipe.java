package com.example.streamtransfer.server;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 创建时间:2019/04/25
 * 创建人:pmc
 * 描述:
 */
//用于消息中转 可对消息进行处理
public interface IPipe
{
    String INPUTT ="inputt";
    String OUTPUTT ="outputt";
    @Input(INPUTT)
    SubscribableChannel inputt();

    @Output(OUTPUTT)
    MessageChannel outputt();
}
