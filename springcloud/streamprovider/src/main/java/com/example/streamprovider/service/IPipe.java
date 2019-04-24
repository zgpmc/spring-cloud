package com.example.streamprovider.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 创建时间:2019/04/23
 * 创建人:pmc
 * 描述:
 */
public interface IPipe
{
    //定义输入通道需要返回SubscribaleChannel接口对象，这个接口继承自MessageChannel接口，它定义了维护消息通道订阅者的方法；定义输出通道则需要返回MessageChannel接口对象，它定义了向消息通道发送消息的方法
    // String INPUTMSG = "output";//创建自定义通道 INPUTMSG
    //
    // @Input(INPUTMSG)
    // public SubscribableChannel input();

    /*//以下写法也可 使用processor 自带的input通道
    @Input(Processor.INPUT)
    public SubscribableChannel input();*/
    //-------------------------------------
    // String OUTPUTMSG = "outputmsg";
    //
    // @Output(OUTPUTMSG)
    // public MessageChannel output();

    /*//以下写法也可 使用processor 自带的OUTPUT通道
    @Output(Processor.OUTPUT)
    public MessageChannel output();*/

    /**
     * mq连接源定义
     * <p>
     * 其中类中的2个属性的值和properties里的配置需要一致
     **/
    // BOSS生产者
    String MESSAGE_OUTPUT = "outputmsg";

    @Output(MESSAGE_OUTPUT)
    MessageChannel messageOutput();
}
