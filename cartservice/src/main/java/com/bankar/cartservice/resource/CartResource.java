package com.bankar.cartservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankar.cartservice.entity.Cart;
import com.bankar.cartservice.entity.Items;
import com.bankar.cartservice.service.CartService;

@RestController
public class CartResource {
	
	@Autowired
	private CartService cartService;
	
	
	
	@PostMapping("/add")
	public Cart addCart(@RequestBody Cart cart) {
		return cartService.addCart(cart);
	}
	
	
	@GetMapping("/get/{id}")
	public Cart getCart(@PathVariable String id) {
		return cartService.getcartById(id);
	}
	
	
	@PutMapping("/update")
	public Cart updateCart(@RequestBody Cart cart) {
		return cartService.updateCart(cart);
	}
	
	
	@PostMapping("/addItem/{id}")
	public Cart addItem(@PathVariable String id,@RequestBody Items item) {
		return cartService.addItem(id,item);
	}
	
	
	@GetMapping("/getAll")
	public List<Cart> getAllCarts(){
		return cartService.getallcarts();
	}
	
	
	

}






