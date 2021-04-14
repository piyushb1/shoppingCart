package com.bankar.orderservice.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bankar.orderservice.models.Orders;

@Repository
public interface OrderRepository extends MongoRepository<Orders,String> {
	
	public Orders findByOrderid(String orderid);
	public List<Orders> findByCustomerid(String customerid);
	public Orders findFirstByOrderByOrderidDesc(int customerid);

}