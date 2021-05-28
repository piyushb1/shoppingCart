package com.bankar.orderservice.resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.bankar.orderservice.models.Orders;
import com.bankar.orderservice.repository.OrderRepository;
import com.bankar.orderservice.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(OrderResource.class)
class OrderResourceTest {
	
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private OrderService service;
	
	ObjectMapper om = new ObjectMapper();
	
	@MockBean
	private OrderRepository repo;

	@Test
	void testGetOrderByOrderid() throws Exception {
		
		String orderid = "s5d8e5d6d4";
		
		Orders orders = new Orders(orderid, "sdds5d5d6d56s5d" , (double)599, "online", "Active", 4);
		Mockito.when(service.getOrderByid(orderid)).thenReturn(orders);
		
		MvcResult result = mockmvc.perform(get("/getorderid/"+orderid)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andReturn();
	                
		String resultContent = result.getResponse().getContentAsString();
		Orders response = om.readValue(resultContent, Orders.class);
		
		assertEquals(orders, response);
	}

	
	@Test
	void testPlaceOrder() throws Exception {
		
		Orders orders = new Orders("sdds5d5d6d56s5d", "sdds5d5d6d56s5d" , (double)599, "online", "Active", 4);
		ObjectMapper objectMapper = new ObjectMapper();
		
		mockmvc.perform(post("/placeOrder")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(orders))
	            .accept(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());	  
	}
	
	
	@Test
	void testNullOrderid() throws Exception {		
		
		mockmvc.perform(get("/getorderid/")
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isNotFound())
	                .andReturn();		
	}
		
	
	@Test
	void testDeleteOrderByid() throws Exception {		
		
		String orderid = "s5d8e5d6d4";
		
		Orders orders = new Orders(orderid, "sdds5d5d6d56s5d" , (double)599, "online", "Active", 4);
		Mockito.when(service.getOrderByid(orderid)).thenReturn(orders);
		
		mockmvc.perform(delete("/deleteOrderByid/"+orderid)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andReturn();		
	}

	
	@Test
	void testInvalidURL() throws Exception {		
		
		mockmvc.perform(get("/asdfghjk123456")
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isNotFound());		
	}
	
	
	@Test
	void testInvalidRequestMethod() throws Exception {		
		
		mockmvc.perform(get("/deleteOrderByid/5689")
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isNotFound());		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
