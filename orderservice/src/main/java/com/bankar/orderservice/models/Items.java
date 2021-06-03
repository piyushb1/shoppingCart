package com.bankar.orderservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Items {
	private String productid;
	private String productName;
	private Double price;
	private String image;
	private int quantity;
}
