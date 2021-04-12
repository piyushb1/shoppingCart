package com.bankar.walletservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bankar.walletservice.pojo.Ewallet;

@Repository
public interface EwalletRepository extends MongoRepository<Ewallet, Object>{
	
	public Ewallet findByWalletid(String walletid);

}
