package org.springframework.message.activemq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XiuYin.Cui on 2018/4/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class QueueTest {

    @Autowired
    private JmsOperations jmsOperations;

    /**
     * jmsOperations.send() 方法，"queue" 不填写，用默认的 Destination
     */
    @Test
    public void send(){
        jmsOperations.send("queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                List<String> list = new ArrayList<>();
                list.add("java");
                list.add("python");
                list.add("c++");
                return session.createObjectMessage((Serializable) list);
            }
        });
    }

    /**
     * jmsOperations 的 receiveAndConvert() 方法
     */
    @Test
    public void receiveAndConvert(){
        List<String> queueName = (List) jmsOperations.receiveAndConvert("queue");
        String s = queueName.get(0);
        System.out.println("-----------" + s + "-------------");
    }


    /*-------------------------------------------------------------------------*/



    /**
     * jmsOperations.convertAndSend() 方法，"queue" 不填写，用默认的 Destination
     */
    @Test
    public void convertAndSend(){
        Map<String ,Object> map = new HashMap<>(16);
        map.put("java", "java");
        map.put("python", "python");
        map.put("c++", "c++");
        jmsOperations.convertAndSend("queue", map);
    }

    /**
     * jmsOperations 的 receive() 方法
     */
    @Test
    public void receive(){
        MapMessage message =(MapMessage)  jmsOperations.receive("queue");
        try {
            String java = message.getString("java");
            System.out.println("----------" + java + "----------");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


    /*----------------------------------------------------------------------*/

    @Test
    public void convertAndSend2(){
        jmsOperations.convertAndSend("text");
    }

    @Test
    public void convertAndSend3(){
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("python");
        list.add("c++");
        jmsOperations.convertAndSend("queueList",list);
    }
}
