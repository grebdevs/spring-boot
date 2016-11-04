package se.kits.svedberg.jms.client.imp;

import se.kits.svedberg.jms.client.JmsClient;
import se.kits.svedberg.jms.consumer.JmsConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kits.svedberg.jms.producer.JmsProducer;

import java.util.Map;

/**
 * Created by Pär Svedberg on 2016-11-01.
 */
@Service
public class JmsClientImpl implements JmsClient {

    @Autowired
    JmsConsumer jmsConsumer;

    @Autowired
    JmsProducer jmsProducer;

    @Override
    public void send(String msg) {
        jmsProducer.send(msg);
    }

    @Override
    public void send(String destination, String msg) {
        jmsProducer.send(destination, msg);
    }

    @Override
    public Map receive(String queue) {
        return jmsConsumer.receive(queue);
    }

    @Override
    public void setTimeout(Long timeout) {
        jmsProducer.setTimeout(timeout);
    }
}
