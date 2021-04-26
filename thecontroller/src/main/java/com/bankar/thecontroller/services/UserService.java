package com.bankar.thecontroller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bankar.thecontroller.models.UserProfile;

@Service
public class UserService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

    public void createuser(UserProfile user) { 
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	restTemplate.postForObject("http://localhost:8094/create",user, UserProfile.class);
    }
}
