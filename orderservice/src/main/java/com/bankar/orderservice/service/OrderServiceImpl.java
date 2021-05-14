package com.bankar.orderservice.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankar.orderservice.models.Items;
import com.bankar.orderservice.models.Address;
import com.bankar.orderservice.models.Cart;
import com.bankar.orderservice.models.Orders;
import com.bankar.orderservice.repository.OrderRepository;
import com.bankar.orderservice.repository.AddressRepository;


@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired private OrderRepository orderrepository;
	@Autowired private AddressRepository addressrepository;

	
	
	public List<Orders> getAllOrders() {
		return orderrepository.findAll();
	}


	public Orders placeOrder(Cart cart) {
		Orders order = new Orders();
		
		order.setProfileid(cart.getCartid());
		order.setOrderDate(LocalDate.now());
		order.setAmmountPaid(cart.getTotalPrice());
		order.setOrderStatus("Active");
		List<Items> tempItem = cart.getItems();
		order.setQuantity(tempItem.size());
		order.setItems(tempItem);
		
		orderrepository.insert(order);
		return order;
	}
	
	public Orders getOrderByid(String orderid) {
		return orderrepository.findByOrderid(orderid);
	}


	public String changeStatus(String status, String id) {
		Orders order = orderrepository.findByOrderid(id);
		order.setOrderStatus(status);
		orderrepository.save(order);
		return status;
	}


	public void deleteOrder(String id) {
		orderrepository.deleteById(id);
	}


	public List<Orders> getOrderByProfileid(String profileid) {
		return orderrepository.findByProfileid(profileid);
	}


	public void storeAddress(Address address) {
		addressrepository.save(address);
	}


	public List<Address> getAddressByProfileid(String profileid) {
		return addressrepository.findAllByCustomerid(profileid);
	}


	public List<Address> getAllAddress() {
		return addressrepository.findAll();
	}


	public Orders getOrderById(String id) {
		return orderrepository.findByOrderid(id);
	}


	public void onlinePayment(Cart cart) {
		// TODO Auto-generated method stub
		
	}

}
