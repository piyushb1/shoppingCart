package com.bankar.orderservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankar.orderservice.models.Address;
import com.bankar.orderservice.models.Cart;
import com.bankar.orderservice.models.Orders;
import com.bankar.orderservice.service.OrderService;


@RestController
public class OrderResource {
	
	@Autowired private OrderService orderService;
	
	
	
	@RequestMapping("/getAll")
	public List<Orders> getAllOrders() {
		return orderService.getAllOrders();
	}
	
	
	@RequestMapping("/getAlla")
	public List<Address> getAllAddress() {
		return orderService.getAllAddress();
	}
	
	
	@RequestMapping("/getoBycust/{customerid}")
	public List<Orders> getOrderByCustomerId(@PathVariable String customerid) {
		return orderService.getOrderByCustomerId(customerid);
	}
	
	
	@RequestMapping("/getaBycust/{customerid}")
	public List<Address> getAddressByCustomerId(@PathVariable String customerid) {
		return orderService.getAddressByCustomerId(customerid);
	}
	
	
//	@RequestMapping("/getmaxbyid")
//	public Orders getMAXByOrderId(@PathVariable String customerid) {
//		return null;
//	}
	
	
	@PostMapping("/placeOrder")
	public Orders placeOrder(@RequestBody Cart cart) {
		return orderService.placeOrder(cart);
	}
	

	@PostMapping("/onlinePayment")
	public void onlinePayment(@RequestBody Cart cart) {
		orderService.onlinePayment(cart);
	}


	@PostMapping("/storeAddress")
	public void storeAddress(@RequestBody Address address) {
		orderService.storeAddress(address);
	}
	
	
	@PutMapping("/changeStatus/{id}")
	public String changeOrderStatus(@RequestBody String status,@PathVariable String id) {
		orderService.changeStatus(status,id);
		return status;
	}
	
	
	@DeleteMapping("/changeStatus/{id}")
	public void deleteOrder(@PathVariable String id) {
		orderService.deleteOrder(id);
	}



}










