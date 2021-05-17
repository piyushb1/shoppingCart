package com.bankar.orderservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankar.orderservice.models.Address;
import com.bankar.orderservice.models.Cart;
import com.bankar.orderservice.models.ListOrder;
import com.bankar.orderservice.models.Orders;
import com.bankar.orderservice.service.OrderService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OrderResource {
	
	@Autowired private OrderService orderService;
	
	
	
	@GetMapping("/getAll")
	public ListOrder getAllOrders() {
		ListOrder listorders = new ListOrder();
		listorders.setListOrder(orderService.getAllOrders());
		return listorders;
	}
	
	
	@GetMapping("/getAlla")
	public List<Address> getAllAddress() {
		return orderService.getAllAddress();
	}
	
	
	@GetMapping("/getoBycust/{profileid}")
	public List<Orders> getOrderByProfileid(@PathVariable String profileid) {
		return orderService.getOrderByProfileid(profileid);
	}
	
	
	@GetMapping("/getaBycust/{profileid}")
	public List<Address> getAddressByProfileid(@PathVariable String profileid) {
		return orderService.getAddressByProfileid(profileid);
	}
	
	@GetMapping("/getorderid/{orderid}")
	public Orders getOrderByid(@PathVariable String orderid) {
		return orderService.getOrderByid(orderid);
	}
	
//	@RequestMapping("/getmaxbyid")
//	public Orders getMAXByOrderId(@PathVariable String customerid) {
//		return null;
//	}
	
	
	@PostMapping("/placeOrder")
	public Orders placeOrder(@RequestBody Orders order) {
		return orderService.placeOrder(order);
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










