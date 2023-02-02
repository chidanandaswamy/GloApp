package com.GloQoura.userdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserDetailsApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserDetailsApplication.class, args);
	}

}
