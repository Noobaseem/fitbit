package com.udaan.interview.fitbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.udaan.interview.fitbit")
public class FitbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitbitApplication.class, args);
	}

}
