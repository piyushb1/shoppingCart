package com.bankar.orderservice.models;

import lombok.Data;

@Data
public class Address {
	
	private String profileid;
	private String fullName;
	private int mobileNumber;
	private String houseNumber;
    private String city;
    private String state;
    private int pincode;  
    private String fulladdress;

}
