package com.bankar.profile.UserProfile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.bankar.profile.UserProfile.pojo.UserProfile;

public interface ProfileService {
	
	public UserProfile addNewCustomerProfile1(@RequestBody UserProfile p);
	public List<UserProfile> getAll();
	public Optional<UserProfile> getByProfileid(String id);
	public UserProfile updateProfile(UserProfile profile);
	public boolean existsById(String id);
	public void deleteProfile(String id);
	public void addNewMerchantProfile(UserProfile profile);
	public void addNewDeliveryProfile(UserProfile profile);
	 public UserProfile findByMobileNo(long mobilenumber);
	 public List<UserProfile> getByUsername(String fullname);

	 
}
