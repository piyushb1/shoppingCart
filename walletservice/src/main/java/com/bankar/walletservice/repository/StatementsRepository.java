package com.bankar.walletservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bankar.walletservice.pojo.Statement;

@Repository
public interface StatementsRepository extends MongoRepository<Statement, Object>{
	
	public Statement findByStatementid(String statementid);

}
