package org.springframework.message.activemq;

import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by XiuYin.Cui on 2018/4/23.
 *
 * EJB 规范的消息驱动监听器，默认调用 onMessage 方法
 */
@Component
public class HandlerListener implements MessageListener {

    /**
     * 如果监听器连接的是这个bean，可以不指定 method ，默认调用 onMessage() 方法
     * @param message
     */
    @Override
    public void onMessage(Message message) {

    }
}
