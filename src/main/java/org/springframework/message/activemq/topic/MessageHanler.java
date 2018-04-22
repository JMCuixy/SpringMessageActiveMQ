package org.springframework.message.activemq.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by XiuYin.Cui on 2018/4/22.
 */
@Component("topicMessageHanler")
public class MessageHanler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageHanler.class);


    public void handle1(String str) {
        LOGGER.info("副本1+++++++++++++++++++++++++" + str + "+++++++++++++++++++++++++");
    }

    public void handle2(String str) {
        LOGGER.info("副本2+++++++++++++++++++++++++" + str + "+++++++++++++++++++++++++");
    }
}
