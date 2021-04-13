package com.bankar.productservice.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@ToString
@Document
public class Product {
	
	@Id
	private String productid;
    private String productType;
    private String productName;
    private String category;
    private Map<String,Double> rating = new HashMap<String,Double>();
    private Map<String,String> review = new HashMap<String,String>();
    private List<String> image = new ArrayList<String>();
	private Double price;
	private String description;
    private Map<String,String> specification = new HashMap<String,String>();
    
    
 
    
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Map<String, Double> getRating() {
		return rating;
	}
	
	
	
	
	public void setRating(String profileid, Double rating) {
		this.rating.put(profileid, rating);
	}
	
	
	
	
	
	public Map<String, String> getReview() {
		return review;
	}
	public void setReview(Map<String, String> review) {
		this.review = review;
	}
	public List<String> getImage() {
		return image;
	}
	public void setImage(List<String> image) {
		this.image = image;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Map<String, String> getSpecification() {
		return specification;
	}
	public void setSpecification(Map<String, String> specification) {
		this.specification = specification;
	}
    


}
