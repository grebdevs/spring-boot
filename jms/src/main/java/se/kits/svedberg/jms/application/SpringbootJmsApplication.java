package se.kits.svedberg.jms.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "se.kits.svedberg.jms")
public class SpringbootJmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJmsApplication.class, args);
	}
}
