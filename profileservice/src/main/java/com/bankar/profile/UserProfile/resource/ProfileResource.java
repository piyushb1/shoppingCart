package com.bankar.profile.UserProfile.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bankar.profile.UserProfile.exception.NotFoundException;
import com.bankar.profile.UserProfile.pojo.ListProfile;
import com.bankar.profile.UserProfile.pojo.UserProfile;
import com.bankar.profile.UserProfile.service.ProfileService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProfileResource {
	
	@Autowired
	private ProfileService profileServ;	
	
	
	@PostMapping("/create")
	public UserProfile addNewCustomerProfile(@RequestBody UserProfile profile) {
		return profileServ.addNewCustomerProfile1(profile);
	}
		
	
	@GetMapping("/getAll")
	public ListProfile getAll(){
		ListProfile listprofile = new ListProfile();
		listprofile.setListproduct(profileServ.getAll());
		return listprofile;
	}
	
	
	@GetMapping("/getById/{id}")
	public UserProfile getById(@PathVariable String id){
		
		if(id==null) {
			throw new NotFoundException("No user found");
		}
		
		UserProfile user =  profileServ.getByProfileid(id);
		if(user==null) {
			throw new NotFoundException("No user found");
		}else {
			return user;
		}
	}
	
	
	@PutMapping("/update/{id}")
	public UserProfile updateProfile(@PathVariable String id,@RequestBody UserProfile profile){
		
		if(profileServ.existsById(id)) {
			return profileServ.updateProfile(profile);
		}
		return null;
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteProfile(@PathVariable String id){
		profileServ.deleteProfile(id);
		return "Deleted ";
	}
	
	
	@GetMapping("/getByPhone/{phno}")
	public UserProfile getByPhoneNumber(@PathVariable Long phno){
		return profileServ.findByMobileNo(phno);
	}
	
	
	@GetMapping("/getByUsername/{username}")
	public List<UserProfile> getByUsername(@PathVariable String username){
		return profileServ.getByUsername(username);
	}
	
	
	@GetMapping("/getByEmail/{email}")
	public UserProfile findByEmail(@PathVariable String email) {
		return profileServ.findByEmail(email);
	}

	

	@PostMapping("/createmerch")
	public void addNewMerchantProfile(@RequestBody UserProfile profile) {
		profileServ.addNewMerchantProfile(profile);
	}
	@PostMapping("/createdelv")
	public void addNewDeliveryProfile(@RequestBody UserProfile profile) {
		profileServ.addNewDeliveryProfile(profile);
	}
	
	
}


























