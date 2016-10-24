package se.kits.svedberg.rest.application;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Pär Svedberg on 2016-10-18.
 */
@SpringBootApplication(scanBasePackages = {"se.kits.svedberg.rest.controller"})
@EnableJpaRepositories(basePackages = {"se.kits.svedberg.rest.repository"}, considerNestedRepositories = true)
@EntityScan(basePackages = {"se.kits.svedberg.rest.model"})
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}