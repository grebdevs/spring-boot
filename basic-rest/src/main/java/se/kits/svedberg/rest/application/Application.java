package se.kits.svedberg.rest.application;

import se.kits.svedberg.rest.controller.ExperienceController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import se.kits.svedberg.rest.service.ExperienceServiceBean;

/**
 * Created by Pär Svedberg on 2016-10-18.
 */
@SpringBootApplication(scanBasePackages={"se.kits.svedberg.rest.service", "se.kits.svedberg.rest.controller"})
//@ComponentScan(basePackageClasses = ExperienceController.class)
//@ComponentScan(basePackageClasses = ExperienceServiceBean.class)
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}