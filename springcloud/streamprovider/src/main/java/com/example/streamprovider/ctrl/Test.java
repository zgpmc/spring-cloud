package com.example.streamprovider.ctrl;

import com.example.streamprovider.service.ServerSendMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间:2019/04/25
 * 创建人:pmc
 * 描述:
 */
@RestController
@RequestMapping(value = "/test")
public class Test
{
    @Autowired
    ServerSendMsg serverSendMsg;

    @RequestMapping(value = "/{msg}")
    public String sendMsg(@PathVariable String msg)
    {
        return serverSendMsg.sendMsg(msg);
    }
}
