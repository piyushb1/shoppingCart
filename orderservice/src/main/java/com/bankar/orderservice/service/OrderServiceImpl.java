package com.bankar.orderservice.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankar.orderservice.exception.NotFoundException;
import com.bankar.orderservice.messaging.CustomMessage;
import com.bankar.orderservice.messaging.MQConfig;
import com.bankar.orderservice.models.Address;
import com.bankar.orderservice.models.Cart;
import com.bankar.orderservice.models.Items;
import com.bankar.orderservice.models.Orders;
import com.bankar.orderservice.repository.AddressRepository;
import com.bankar.orderservice.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired private OrderRepository orderrepository;
	@Autowired private AddressRepository addressrepository;
	@Autowired private RabbitTemplate template;

	
	
	public List<Orders> getAllOrders() {
		return orderrepository.findAll();
	}


	public Orders placeOrder(Orders orderinput) {
		Orders order = new Orders();
		
		order.setProfileid(orderinput.getProfileid());
		order.setOrderDate(LocalDate.now());
		order.setAmmountPaid(orderinput.getAmmountPaid());
		order.setOrderStatus("Active");
		List<Items> tempItem = orderinput.getItems();
		order.setQuantity(tempItem.size());
		order.setItems(tempItem);
		order.setAddress(orderinput.getAddress());
		order.setModeOfPayment(orderinput.getModeOfPayment());
		
		orderrepository.insert(order);
				
		CustomMessage message = new CustomMessage(UUID.randomUUID().toString(), orderinput.getProfileid(), new Date());
		template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
                
		return order;
	}
	
	public Orders getOrderByid(String orderid) {
		
		Orders orders1 = orderrepository.findByOrderid(orderid);
		
		if(orders1!=null) {
			return orderrepository.findByOrderid(orderid);			
		}
		else {
			throw new NotFoundException("Order with id = '"+orderid+"' does not exist");
		}
	}


	public String changeStatus(String status, String id) {
		Orders order = orderrepository.findByOrderid(id);
		order.setOrderStatus(status);
		orderrepository.save(order);
		return status;
	}


	public void deleteOrder(String id) {
		if(!orderrepository.existsById(id))
			throw new NotFoundException("Order with id = '"+id+"' does not exist");
		orderrepository.deleteById(id);
	}


	public List<Orders> getOrderByProfileid(String profileid) {
		List<Orders> listorder = orderrepository.findAllByProfileid(profileid);
		
		if(listorder==null)
			throw new NotFoundException("Profile with id = '"+profileid+"' does not have any orders");
		
		return orderrepository.findAllByProfileid(profileid);
	}


	public void storeAddress(Address address) {
		addressrepository.save(address);
	}


	public List<Address> getAddressByProfileid(String profileid) {
		return addressrepository.findAllByProfileid(profileid);
	}


	public List<Address> getAllAddress() {
		return addressrepository.findAll();
	}


	public void onlinePayment(Cart cart) {
		// TODO Auto-generated method stub
		
	}

}
