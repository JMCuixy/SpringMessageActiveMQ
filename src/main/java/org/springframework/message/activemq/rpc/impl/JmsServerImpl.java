package org.springframework.message.activemq.rpc.impl;

import org.springframework.message.activemq.rpc.JmsServer;
import org.springframework.stereotype.Component;

/**
 * Created by XiuYin.Cui on 2018/4/24.
 */
@Component("jmsServerImpl")
public class JmsServerImpl implements JmsServer {


    @Override
    public void doServer(String str) {
        System.out.println("your message::".concat(str).concat(":::length:") + str.length());
    }
}
