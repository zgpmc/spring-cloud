package com.example.streamprovider.extend;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/**
 * 创建时间:2019/04/23
 * 创建人:pmc
 * 描述:
 */
public class BossMessage implements Message
{
    @Override
    public Object getPayload()
    {
        return null;
    }

    @Override
    public MessageHeaders getHeaders()
    {
        return null;
    }
}
