package com.bankar.orderservice.service;

import java.util.List;

import com.bankar.orderservice.models.Address;
import com.bankar.orderservice.models.Cart;
import com.bankar.orderservice.models.Orders;

public interface OrderService {
	
	public List<Orders> getAllOrders();
	public Orders placeOrder(Cart cart);
	public String changeStatus(String staus, String id);
	public void deleteOrder(String id);
	public List<Orders> getOrderByCustomerId(String id);
	public void storeAddress(Address address);
	public List<Address> getAddressByCustomerId(String id);
	public List<Address> getAllAddress();
	public Orders getOrderById(String id);
	public void onlinePayment(Cart cart);
	
}
