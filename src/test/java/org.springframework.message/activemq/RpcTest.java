package org.springframework.message.activemq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.message.activemq.rpc.JmsServer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by XiuYin.Cui on 2018/4/24.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RpcTest {


    /**
     * @// TODO: 2018/4/24 Forbidden class org.springframework.remoting.support.RemoteInvocation!
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        JmsServer service = (JmsServer)context.getBean("jmsServerProxy");
        service.doServer("Hello Message");
    }



}
