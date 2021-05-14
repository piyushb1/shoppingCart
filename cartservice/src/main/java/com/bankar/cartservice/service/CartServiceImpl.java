package com.bankar.cartservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bankar.cartservice.entity.Cart;
import com.bankar.cartservice.entity.Items;
import com.bankar.cartservice.entity.Product;
import com.bankar.cartservice.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	
	
	
	public Cart addCart(String id) {
		Cart cart = new Cart();
		cart.setCartid(id);
		return cartRepository.insert(cart);
	}
	
	
	public Cart getcartById(String id) {
		Cart cart = new Cart();
		if(cartRepository.existsById(id)) {
			cart = cartRepository.findBycartid(id);
		}
		else {
			cart.setCartid(id);
		}
		return cart;
	}
	
	
	public Cart updateCart(Cart cart) {
		return cartRepository.save(cart);
	}
	
	
	public List<Cart> getallcarts() {
		return cartRepository.findAll();
	}
	
	
	public double cartTotal(Cart cart) {
		return cart.getTotalPrice();
	}
	

	public Cart addItem(String id, Items item) {
		Cart cart = new Cart();
		if(cartRepository.existsById(id)) {
			cart = cartRepository.findBycartid(id);
		}
		else {
			cart.setCartid(id);
		}
		cart.addItem(item);
		return cartRepository.save(cart);
	}
	
	public Cart removeItem(String cartid, Items item) {
		Cart cart = new Cart();
		cart = cartRepository.findBycartid(cartid);
		
		cart.removeItems(item.getProductid());
		return cartRepository.save(cart);
	}

	

}







