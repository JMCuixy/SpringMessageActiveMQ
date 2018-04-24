package org.springframework.message.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;

/**
 * Created by XiuYin.Cui on 2018/4/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JmsTest {

    @Test
    public void producer(){
        ConnectionFactory cf = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        Connection conn = null;
        Session session = null;
        try {
            conn = cf.createConnection();
            conn.start();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = new ActiveMQQueue("queueTest");
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage("Hello Message");
            producer.send(message);
            conn.stop();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (session != null){
                    session.close();
                }
                if (conn != null){
                    conn.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void consumer(){
        ConnectionFactory cf = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        Connection conn = null;
        Session session = null;
        try {
            conn = cf.createConnection();
            conn.start();
            session = conn.createSession(true ,Session.AUTO_ACKNOWLEDGE);
            Destination destination = new ActiveMQQueue("queueTest");
            MessageConsumer consumer = session.createConsumer(destination);
            Message receive = consumer.receive(5000L);
            TextMessage message = (TextMessage) receive;
            if (message != null) System.out.println("---------------" + message.getText() + "------------------");
            conn.stop();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (session != null){
                    session.close();
                }
                if (conn != null){
                    conn.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
