package com.example.AccountingTools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.AccountingTools.model")

@EnableJpaRepositories(basePackages = "com.example.AccountingTools.repositories")
public class AccountingToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountingToolsApplication.class, args);
	}

}
