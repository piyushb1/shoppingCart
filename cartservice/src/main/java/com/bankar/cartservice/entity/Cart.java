package com.bankar.cartservice.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
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
	
	public void addItem(Items item) {
//		boolean isThere=false;
		
		for(Items i:this.items) {
			if(i.getProductid()==item.getProductid()) {
				i.setQuantity(i.getQuantity()+1);
				break;
			}
		}
		
		this.items.add(item);
		
	}
	
	
	public void removeItems(String productid) {
		
		for(Items i:this.items) {
			if(i.getProductid()==productid) {
				if(i.getQuantity()>1) {
					i.setQuantity(i.getQuantity()-1);
				}
				else {
					this.items.removeIf(it -> it.getProductid().equals(productid));
				}
			}
		}
	}

	
	
	
	
	
	
	
}
