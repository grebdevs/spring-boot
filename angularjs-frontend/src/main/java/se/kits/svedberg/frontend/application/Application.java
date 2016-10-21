package se.kits.svedberg.frontend.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Pär Svedberg on 2016-10-19.
 */
@SpringBootApplication(scanBasePackages={"se.kits.svedberg.frontend.controller", "se.kits.svedberg.frontend.service"})
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}