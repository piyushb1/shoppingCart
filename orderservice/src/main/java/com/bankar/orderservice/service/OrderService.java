package com.bankar.orderservice.service;

import java.util.List;

import com.bankar.orderservice.models.Address;
import com.bankar.orderservice.models.Cart;
import com.bankar.orderservice.models.Orders;

public interface OrderService {
	
	public List<Orders> getAllOrders();
	public Orders placeOrder(Orders order);
	public Orders changeStatus(String id);
	public void deleteOrder(String id);
	public List<Orders> getOrderByProfileid(String profileid);
	public void storeAddress(Address address);
	public List<Address> getAddressByProfileid(String profileid);
	public List<Address> getAllAddress();
	public void onlinePayment(Cart cart);
	public Orders getOrderByid(String orderid);
	
}
