package org.springframework.message.activemq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by XiuYin.Cui on 2018/4/22.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TopicTest {

    @Autowired
    private JmsOperations jmsOperations;

    @Test
    public void send(){
        jmsOperations.send("topicName", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("Hello Topic");
            }
        });
    }

    @Test
    public void convertAndSend(){
        jmsOperations.convertAndSend("topicName","Hello topic");
    }

    @Test
    public void receiveAndConvert(){
        String topicName =(String) jmsOperations.receiveAndConvert("topicName");
        System.out.println("--------------------------" + topicName + "-------------------------");
    }





}
