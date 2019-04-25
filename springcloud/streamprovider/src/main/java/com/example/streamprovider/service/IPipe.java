package com.example.streamprovider.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Service;

/**
 * 创建时间:2019/04/23
 * 创建人:pmc
 * 描述:
 */
@Service
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
    String MESSAGE_OUTPUT = "outputmsg";//生产者监控返回

    //如果不指定 写output() 默认会将方法名设置为通道名写output("messageOutput")
    @Output(MESSAGE_OUTPUT)
    MessageChannel messageOutput();

    //消费者
    String MESSAGE_INPUT = "inputmsg";//生产者监控消费者返回 所以值是反的

    @Input(MESSAGE_INPUT)
    SubscribableChannel messageInput();
    /*String MESSAGE_OUTPUT_2 = "outputmsg2";

    @Output(MESSAGE_OUTPUT_2)
    MessageChannel messageOutput2();

    //消费者
    String MESSAGE_INPUT1 = "inputmsg1";

    @Input(MESSAGE_INPUT1)
    SubscribableChannel messageInput1();*/
}
