package com.api;

import com.api.Exception.HnDBankException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.api")
@EnableJpaRepositories(basePackages = "com.api.repository")
@EntityScan(basePackages = "com.api.entity")
@SpringBootApplication
public class FirstSpringBootApplication {

	public static void main(String[] args) throws HnDBankException {
		SpringApplication.run(FirstSpringBootApplication.class, args);
		System.out.println("Hello World!");
	}

}
