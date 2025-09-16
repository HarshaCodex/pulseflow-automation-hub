package com.pulseflow.rule_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RuleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuleServiceApplication.class, args);
	}

}
