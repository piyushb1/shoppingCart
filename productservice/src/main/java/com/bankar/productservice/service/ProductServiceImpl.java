package com.bankar.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankar.productservice.entity.Product;
import com.bankar.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productrepository;	
	
	
	
	public Product addProduct(Product product) {
		return productrepository.insert(product);
	}
	
	
	public List<Product> getAllProducts(){
		return productrepository.findAll();
	}
	
	
	public Product getByProductid(String id){
		return productrepository.findByproductid(id);
	}
	
	
	public Product getByProductByName(String productName){
		return productrepository.findByproductName(productName);	
	}
	
	
	public Product updateProduct(Product product){
		return productrepository.save(product);
	}
	
	
	public void deleteProductById(String id) {
		productrepository.deleteById(id);
	}
	
	
	public List<Product> getByProductByCategory(String category) {
		return productrepository.findBycategory(category);
	}
	
	
	public List<Product> getByProductByType(String productType) {
		return productrepository.findByproductType(productType);
	}

	
	public boolean existsById(String id) {
		return productrepository.existsById(id);
	}
	
	
	public Product rating(String productid, String profileid, Double rating) {
		Optional<Product> optional = productrepository.findById(productid);
		Product product = optional.get();
		product.setRating(profileid, rating);
		return product;
	}

	
}
























