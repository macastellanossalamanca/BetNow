package edu.escuelaing.BetNow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BetNow {
	public static void main(String[] args) {
		SpringApplication.run(BetNow.class, args);
	}
}
