package se.kits.svedberg.jms.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static javax.jms.Message.DEFAULT_TIME_TO_LIVE;

/**
 * Created by Pär Svedberg
 */
@Component
public class JmsProducer {
    private static Logger logger = LoggerFactory.getLogger(JmsProducer.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @PostConstruct
    public void init() {
        jmsTemplate.setExplicitQosEnabled(true);
        logger.info("isExplicitQosEnabled(): " + jmsTemplate.isExplicitQosEnabled());
    }

    public void send(String destinationQueue, String msg){
        jmsTemplate.convertAndSend(destinationQueue, msg);
    }

    public void setTimeout(Long timeout) {
        timeout = timeout == null ? DEFAULT_TIME_TO_LIVE : timeout * 1000L;
        jmsTemplate.setTimeToLive(timeout);
        logger.info("JmsProducer: " + timeout);
    }
}
