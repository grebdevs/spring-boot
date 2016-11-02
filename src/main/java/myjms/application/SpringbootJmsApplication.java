package myjms.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "myjms")
public class SpringbootJmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJmsApplication.class, args);
	}
}
