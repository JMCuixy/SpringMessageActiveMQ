package org.springframework.message.activemq.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by XiuYin.Cui on 2018/4/22.
 */
@Component("queueMessageHandler")
public class MessageHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageHandler.class);

    public void handle(String str) {
        LOGGER.info("+++++++++++++++++++++++++" + str + "+++++++++++++++++++++++++");
    }

    public void handle2(List list){
        for (Object o : list){
            System.out.println(o);
        }
    }
}
