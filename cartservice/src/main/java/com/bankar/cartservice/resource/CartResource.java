package com.bankar.cartservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankar.cartservice.entity.Cart;
import com.bankar.cartservice.entity.Items;
import com.bankar.cartservice.service.CartService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CartResource {
	
	
	@Autowired
	private CartService cartService;
		
	
	
	@PostMapping("/add/{id}")
	public Cart addCart(@RequestBody String id) {
		return cartService.addCart(id);
	}
	
	
	@GetMapping("/get/{id}")
	public Cart getCart(@PathVariable String id) {
		return cartService.getcartById(id);
	}
	
	
	@PutMapping("/update")
	public Cart updateCart(@RequestBody Cart cart) {
		return cartService.updateCart(cart);
	}
	
	
	@PostMapping("/addItem/{userid}")
	public Cart addItem(@PathVariable String userid,@RequestBody Items item) {
		return cartService.addItem(userid,item);
	}
	
	
	@GetMapping("/getAll")
	public List<Cart> getAllCarts(){
		return cartService.getallcarts();
	}
	
	
	

}






