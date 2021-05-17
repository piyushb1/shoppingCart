package com.bankar.orderservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bankar.orderservice.models.Address;

@Repository
public interface AddressRepository extends MongoRepository<Address, Object>{
	
	public List<Address> findAllByProfileid(String profileid);

}
