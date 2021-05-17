package com.bankar.thecontroller.resource;

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
import org.springframework.web.client.RestTemplate;

import com.bankar.thecontroller.models.ListProduct;
import com.bankar.thecontroller.models.Product;
import com.bankar.thecontroller.models.UserProfile;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductResource {

	
	@Autowired
	private RestTemplate restTemplate;
	
		
	
	@GetMapping("/getAll")
	public List<Product> getAll(){
		ListProduct listproduct = restTemplate.getForObject("http://localhost:8093/getAll", ListProduct.class);
		return listproduct.getListproduct();
	}
	
	
//
//	@PostMapping("/create")
//	public Product addProducts(@RequestBody Product product) {
//		return productServ.addProduct(product);
//	}
//	
	
	@GetMapping("/getId/{id}")
	public Product getByProductid(@PathVariable String id){
		Product product = restTemplate.getForObject("http://localhost:8093/getId/"+id, Product.class);
		return product;
	}
	
//	
//	@GetMapping("/getByName/{productName}")
//	public Product getByProductByName(@PathVariable String productName){
//		return productServ.getByProductByName(productName);
//	}
//	
//	
//	@PutMapping("/update/{id}")
//	public Product updateProduct(@PathVariable String id,@RequestBody Product product) {
//		if(productServ.existsById(id)) {
//			return productServ.updateProduct(product);
//		}
//		return null;
//	}
//
//	
//	@PutMapping("/ratings/{productid}")
//	public Product rate(@PathVariable String productid,@RequestBody String profileid,@RequestBody Double rating) {
//		return productServ.rating(productid,profileid,rating);
//	}
//	
//	
//	@DeleteMapping("/delete/{id}")
//	public void deleteProductById(@PathVariable String id) {
//		if(productServ.existsById(id)) {
//			productServ.deleteProductById(id);
//		}
//	}
//	
//	
//	@GetMapping("/getByCategory/{category}")
//	public List<Product> getByProductByCategory(@PathVariable String category) {
//		return productServ.getByProductByCategory(category);
//	}
//	
//	
//	@GetMapping("/getByType/{productType}")
//	public List<Product> getByProductByType(@PathVariable String productType) {
//		return productServ.getByProductByType(productType);
//	}

	
}






















