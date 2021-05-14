package com.bankar.profile.UserProfile.pojo;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@ToString
@Document
public class UserProfile {
	
	@Id
	private String profileid;
    private String fullname;
    private String image;
    private String email;
    private Long mobilenumber;
    private String about;
    private LocalDate dateOfBirth;
    private String gender;
    private String role;
    private String password;
    private Address address;
    
    
    public UserProfile(String profileid, String email, Long mobilenumber, String password) {
		super();
		this.email = email;
		this.profileid = profileid;
		this.mobilenumber = mobilenumber;
		this.password = password;
	}
    
    
	public String getProfileid() {
		return profileid;
	}
	public void setProfileid(String profileid) {
		this.profileid = profileid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String emailid) {
		this.email = emailid;
	}
	public Long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String deliveryagent) {
		this.role = deliveryagent;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
    
    
   
}
