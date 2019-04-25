package com.example.streamcustomer.server;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 创建时间:2019/04/24
 * 创建人:pmc
 * 描述:
 */
public interface IPipe
{
    String MESSAGE_INPUT = "inputmsg";

    @Input(MESSAGE_INPUT)
    SubscribableChannel messageInput();

    String MESSAGE_OUTPUT = "outputmsg";

    @Output(MESSAGE_OUTPUT)
    MessageChannel messageOutput();
}
