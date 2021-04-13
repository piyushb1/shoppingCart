package com.bankar.orderservice.models;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Product {
	
	@Id
	private String productid;
    private String productType;
  

}
