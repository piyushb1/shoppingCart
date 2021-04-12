package com.bankar.cartservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bankar.cartservice.entity.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, String>{
	
	public Cart findBycartid(String id);

}
