package myjms.controller;

import myjms.client.JmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Pär Svedberg on 2016-11-01.
 */
@RestController
public class WebController {

    @Autowired
    JmsClient jmsClient;

    @RequestMapping(value="/produce", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void produce(@RequestParam(name = "queue", required = false)String queue, @RequestParam("msg")String msg){
        if (queue == null) {
            jmsClient.send(msg);
        } else {
            jmsClient.send(queue, msg);
        }
    }

    @RequestMapping(value="/receive")
    public String receive(){
        return jmsClient.receive();
    }
}
