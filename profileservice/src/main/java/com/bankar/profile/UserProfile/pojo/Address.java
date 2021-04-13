package com.bankar.profile.UserProfile.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Address {
	
	private int houseNumber;
    private String streetName;
    private String colonyName;
    private String city;
    private String state;
    private int pincode;  
    
    
}