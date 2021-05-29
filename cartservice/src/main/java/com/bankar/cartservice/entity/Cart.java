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
	private ArrayList<Items> items = new ArrayList<Items>();


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
		boolean isnotThere=true;
		
		
		for(int i = 0; i < items.size(); i++){
			if (items.get(i).getProductid().equals(item.getProductid())){
				isnotThere = false;
            	items.get(i).setQuantity(items.get(i).getQuantity()+1);
                break;
            }
			else if(i==items.size()) {
				items.add(item);
			}
        }
		if(isnotThere) {
			items.add(item);
		}
		
				
	}
	
	
	public void removeItems(String productid) {
		
		for(int i = 0; i < items.size(); i++){
			if (items.get(i).getProductid().equals(productid)){
				
				if(items.get(i).getQuantity() <= 1) {
					items.remove(i);
				}
				else {
				items.get(i).setQuantity(items.get(i).getQuantity()-1);
				}
                break;
            	
			}
        }
	
	}

	
	
	
	
	
	
	
}
