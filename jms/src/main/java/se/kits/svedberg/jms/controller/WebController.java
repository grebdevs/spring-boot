package se.kits.svedberg.jms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import se.kits.svedberg.jms.client.JmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Pär Svedberg
 */
@RestController
public class WebController {

    @Autowired
    JmsClient jmsClient;

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping(value="/produce", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void produce(@RequestParam(name = "queue", required = false) String queue,
                        @RequestParam("msg") String msg,
                        @RequestParam(name = "timeout", required = false) Long timeout){
        jmsClient.setTimeout(timeout);
        logger.info("Timeout: " + timeout);
        jmsClient.send(queue, msg);
    }

    @RequestMapping(value="/receive", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map receive(@RequestParam(name = "queue", required = false) String queue){
        return jmsClient.receive(queue);
    }
}
