package com.bankar.orderservice.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Cart {
	
	@Id private String cartid;
	private double totalPrice;
	private List<Items> items = new ArrayList<Items>();


	public double getTotalPrice() {
		totalPrice=0;
		
		if(items != null) {			
			items.forEach((temp) -> {
				totalPrice += temp.getQuantity()*temp.getPrice();
	        });			
			return totalPrice;
		}
		
		return totalPrice;
	}

}
