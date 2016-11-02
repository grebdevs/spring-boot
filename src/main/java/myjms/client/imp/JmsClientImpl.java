package myjms.client.imp;

import myjms.client.JmsClient;
import myjms.consumer.JmsConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import myjms.producer.JmsProducer;

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
    public String receive() {
        return jmsConsumer.receive();
    }

}
