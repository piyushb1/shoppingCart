package com.bankar.productservice.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankar.productservice.entity.Product;
import com.bankar.productservice.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductResource {

	@Autowired
	private ProductService productServ;
	
	
	
	@PostMapping("/create")
	public Product addProducts(@RequestBody Product product) {
		return productServ.addProduct(product);
	}
	
	
	@GetMapping("/getAll")
	public List<Product> getAll(){
		return productServ.getAllProducts();
	}
	
	
	@GetMapping("/getId/{id}")
	public Product getByProductid(@PathVariable String id){
		return productServ.getByProductid(id);
	}
	
	
	@GetMapping("/getByName/{productName}")
	public Product getByProductByName(@PathVariable String productName){
		return productServ.getByProductByName(productName);
	}
	
	
	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable String id,@RequestBody Product product) {
		if(productServ.existsById(id)) {
			return productServ.updateProduct(product);
		}
		return null;
	}

	
	@PutMapping("/ratings/{productid}")
	public Product rate(@PathVariable String productid,@RequestBody String profileid,@RequestBody Double rating) {
		return productServ.rating(productid,profileid,rating);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteProductById(@PathVariable String id) {
		if(productServ.existsById(id)) {
			productServ.deleteProductById(id);
		}
	}
	
	
	@GetMapping("/getByCategory/{category}")
	public List<Product> getByProductByCategory(@PathVariable String category) {
		return productServ.getByProductByCategory(category);
	}
	
	
	@GetMapping("/getByType/{productType}")
	public List<Product> getByProductByType(@PathVariable String productType) {
		return productServ.getByProductByType(productType);
	}

	
}






















