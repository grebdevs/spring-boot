package se.kits.svedberg.jms.controller;

import org.springframework.http.MediaType;
import se.kits.svedberg.jms.client.JmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Pär Svedberg on 2016-11-01.
 */
@RestController
public class WebController {

    @Autowired
    JmsClient jmsClient;

    @RequestMapping(value="/produce", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void produce(@RequestParam(name = "queue", required = false) String queue, @RequestParam("msg") String msg){
        if (queue == null || queue.isEmpty()) {
            jmsClient.send(msg);
        } else {
            System.out.println(queue);
            jmsClient.send(queue, msg);
            System.out.println(queue);
        }
    }

    @RequestMapping(value="/receive", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map receive(@RequestParam(name = "queue", required = false) String queue){
        return jmsClient.receive(queue);
    }
}
