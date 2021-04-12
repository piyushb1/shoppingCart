package com.bankar.cartservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankar.cartservice.entity.Cart;
import com.bankar.cartservice.entity.Items;
import com.bankar.cartservice.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	
	
	public Cart addCart(Cart cart) {
		return cartRepository.insert(cart);
	}
	
	
	public Cart getcartById(String id) {
		return cartRepository.findBycartid(id);
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
	
	
	public Cart addItem(String id,Items item) {		
		Cart cart = cartRepository.findBycartid(id);
		List<Items> tempItem = cart.getItems();
		tempItem.add(item);
		cart.setItems(tempItem);
		return cartRepository.save(cart);		
	}

	

}







