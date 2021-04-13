package com.bankar.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.bankar.productservice.entity.Product;

public interface ProductService {
	
	public Product addProduct(Product product);
	public List<Product> getAllProducts();
	public Optional<Product> getByProductid(String id);
	public Optional<Product> getByProductByName(String productName);
	public Product updateProduct(Product product);
	public boolean existsById(String id);
	public void deleteProductById(String id);
	public List<Product> getByProductByCategory(String category);
	public List<Product> getByProductByType(String productType);
	public Product rating(String productid, String profileid, Double rating);


}
