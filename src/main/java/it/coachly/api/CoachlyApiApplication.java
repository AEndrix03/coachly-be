package it.coachly.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CoachlyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoachlyApiApplication.class, args);
	}

}
