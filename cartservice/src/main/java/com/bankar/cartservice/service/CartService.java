package com.bankar.cartservice.service;

import java.util.List;

import com.bankar.cartservice.entity.Cart;
import com.bankar.cartservice.entity.Items;

public interface CartService {
	
	public Cart addCart(String id);
	public Cart getcartById(String id);
	public Cart updateCart(Cart cart);
	public List<Cart> getallcarts();
	public double cartTotal(Cart cart);
	public Cart addItem(String id,Items item);
	public Cart removeItem(String cartid, Items item);
	public Cart emptyCart(String cartid);
	

}
