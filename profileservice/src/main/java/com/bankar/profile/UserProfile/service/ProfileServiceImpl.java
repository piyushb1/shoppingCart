package com.bankar.profile.UserProfile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bankar.profile.UserProfile.pojo.Role;
import com.bankar.profile.UserProfile.pojo.UserProfile;
import com.bankar.profile.UserProfile.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired
	private ProfileRepository profilerepository;	
	
	
	
	//Insert profile
	public UserProfile addNewCustomerProfile1(@RequestBody UserProfile profile) {
		profile.setRole(Role.Customer);
		return profilerepository.insert(profile);
	}
	
	
	//Find all profiles
	public List<UserProfile> getAll(){
		List<UserProfile> users = profilerepository.findAll();
		return users;
	}

	
	//Find profile by Id
	public UserProfile getByProfileid(String id) {
		UserProfile user = profilerepository.findByprofileid(id);
		return user;
	}
	
	
	//Update profile by id
	public UserProfile updateProfile(@RequestBody UserProfile profile) {
		UserProfile user = profilerepository.findByprofileid(profile.getProfileid());
		user.setFullname(profile.getFullname());
		user.setEmail(profile.getEmail());
		user.setGender(profile.getGender());
		user.setMobilenumber(profile.getMobilenumber());
		user.setAbout(profile.getAbout());
		profilerepository.save(user);
		return user;
	}
	
	
	public void deleteProfile(String id) {
		profilerepository.deleteById(id);
	}
	
	
	
	 public void addNewMerchantProfile(@RequestBody UserProfile profile) {
		 profile.setRole(Role.Merchant);
		 profilerepository.insert(profile);
	 }
	 
	 
	 public void addNewDeliveryProfile(@RequestBody UserProfile profile) {
		 profile.setRole(Role.DeliveryAgent);
		 profilerepository.insert(profile);
	 }
	 
	 
	 public UserProfile findByMobileNo(long mobilenumber) {
		 return profilerepository.findAllBymobilenumber(mobilenumber);
	 }
	 
	 
	 public List<UserProfile> getByUsername(String fullname){
		 return profilerepository.findByfullname(fullname);
	 }
	 

	public boolean existsById(String id) {
		return profilerepository.existsById(id);
	}


	public UserProfile findByEmail(String email) {
		return profilerepository.findByemail(email);
	}

	

}




















