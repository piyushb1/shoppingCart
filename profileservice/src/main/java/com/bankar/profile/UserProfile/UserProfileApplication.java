package com.bankar.profile.UserProfile;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEurekaClient
@SpringBootApplication
public class UserProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProfileApplication.class, args);
	}

}
