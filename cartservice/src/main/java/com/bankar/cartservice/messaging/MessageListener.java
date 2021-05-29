package com.bankar.cartservice.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankar.cartservice.service.CartService;

@Component
public class MessageListener {
	

	@Autowired
	private CartService cartService;
	

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(CustomMessage message) {
    	
    	cartService.emptyCart(message.getProfileid());
    	
        System.out.println("New Cart is ordered by User = "+message.getProfileid());
    }

}
