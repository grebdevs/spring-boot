package se.kits.svedberg.jms.client.implementation;

import org.springframework.beans.factory.annotation.Value;
import se.kits.svedberg.jms.client.JmsClient;
import se.kits.svedberg.jms.consumer.JmsConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kits.svedberg.jms.producer.JmsProducer;

import java.util.Map;

/**
 * Created by Pär Svedberg
 */
@Service
public class JmsClientImpl implements JmsClient {

    @Value("${jms.queue.destination}")
    String defaultQueue;

    @Autowired
    JmsConsumer jmsConsumer;

    @Autowired
    JmsProducer jmsProducer;

    @Override
    public void send(String destination, String msg) {
        destination = (destination == null || destination.isEmpty()) ? defaultQueue : destination;
        jmsProducer.send(destination, msg);
    }

    @Override
    public Map receive(String queue) {
        queue = (queue == null || queue.isEmpty()) ? defaultQueue : queue;
        return jmsConsumer.receive(queue);
    }

    @Override
    public void setTimeout(Long timeout) {
        jmsProducer.setTimeout(timeout);
    }
}
