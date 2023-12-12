package com.guner.springbootjpaaudit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class SpringBootJpaAuditApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaAuditApplication.class, args);
	}

}
