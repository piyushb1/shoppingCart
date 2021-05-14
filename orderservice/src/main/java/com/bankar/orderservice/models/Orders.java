package com.bankar.orderservice.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Orders {
	
	@Id
	private String orderid;
	private LocalDate orderDate;
	private String profileid;
	private Double ammountPaid;
    private String modeOfPayment;
    private String orderStatus;
    private int quantity;  
    private Address address;  
    private Product product;
    private List<Items> items = new ArrayList<Items>();


}
