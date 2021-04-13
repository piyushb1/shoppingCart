package com.bankar.orderservice.models;

import lombok.Data;

@Data
public class Address {
	
	private String customerid;
	private String fullName;
	private int mobileNumber;
	private int houseNumber;
    private String city;
    private String state;
    private int pincode;  

}
