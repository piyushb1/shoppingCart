package com.bankar.productservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bankar.productservice.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
	
	public Product findByproductid(String productid);
	public Product findByproductName(String productName);
	public List<Product> findBycategory(String category);
	public List<Product> findByproductType(String productType);
	 

}
