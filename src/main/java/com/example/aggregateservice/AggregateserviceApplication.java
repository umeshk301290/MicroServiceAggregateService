package com.example.aggregateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AggregateserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AggregateserviceApplication.class, args);
	}

	@Bean
	RestTemplate geRestTemplate() {
		
		return new RestTemplate();
	}
}
