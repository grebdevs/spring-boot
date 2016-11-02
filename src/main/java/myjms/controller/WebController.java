package myjms.controller;

import myjms.client.JmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pär Svedberg on 2016-11-01.
 */
@RestController
public class WebController {

    @Autowired
    JmsClient jmsClient;

    @RequestMapping(value="/produce")
    public String produce(@RequestParam(name = "queue", required = false)String queue, @RequestParam("msg")String msg){
        if (queue == null && msg == null) {
            return "Got null parameters";
        }
        if (queue == null) {
            jmsClient.send(msg);
        } else {
            jmsClient.send(queue, msg);
        }
        return "Done";
    }

    @RequestMapping(value="/receive")
    public String receive(){
        return jmsClient.receive();
    }
}
