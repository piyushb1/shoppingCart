package com.bankar.thecontroller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bankar.thecontroller.models.UserProfile;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private RestTemplate restTemplate;

    @Override
    public MyUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    	UserProfile user = restTemplate.getForObject("http://localhost:8094/getByEmail/"+s, UserProfile.class);
    	MyUserDetails myUserDetails = new MyUserDetails(user);
    	return myUserDetails;

    }
}