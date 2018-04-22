package org.springframework.message.activemq.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by XiuYin.Cui on 2018/4/22.
 */
@Component("queueMessageHanler")
public class MessageHanler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageHanler.class);

    public void handle(String str) {
        LOGGER.info("+++++++++++++++++++++++++" + str + "+++++++++++++++++++++++++");
    }
}
