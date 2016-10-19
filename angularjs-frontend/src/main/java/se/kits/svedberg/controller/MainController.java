package se.kits.svedberg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Pär Svedberg on 2016-10-19.
 */

@Controller
public class MainController {

    @RequestMapping("/")
    public String homepage() {
        return "index";
    }
}
