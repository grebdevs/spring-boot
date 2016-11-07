package se.kits.svedberg.jms.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pär Svedberg
 */
@Component
public class JmsConsumer {
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${jms.queue.destination}")
    String defaultQueue;

    public Map receive(String queue){
        Map<String, String> map = new HashMap<>();
        queue = (queue == null || queue.isEmpty()) ? defaultQueue : queue;
        map.put("queue", queue);
        map.put("msg", (String) jmsTemplate.receiveAndConvert(queue));
        return map;
    }
}