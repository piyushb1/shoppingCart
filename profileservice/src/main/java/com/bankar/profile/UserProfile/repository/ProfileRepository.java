package com.bankar.profile.UserProfile.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bankar.profile.UserProfile.pojo.UserProfile;

@Repository
public interface ProfileRepository extends MongoRepository<UserProfile, String>{

	 public UserProfile findAllBymobilenumber(long mobilenumber);
	 public List<UserProfile> findByfullname(String fullname);
	
}
