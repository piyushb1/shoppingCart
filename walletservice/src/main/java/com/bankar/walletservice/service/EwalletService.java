package com.bankar.walletservice.service;

import java.util.List;

import com.bankar.walletservice.pojo.Ewallet;
import com.bankar.walletservice.pojo.Statement;

public interface EwalletService {
	
	public List<Ewallet> getWallets();
	public Ewallet addEwallet(Ewallet ewallet);
	public void addMoney(String walletid,double money);
	public void update(String walletid,Ewallet ewallet);
	public Ewallet getById(String walletid);
	public List<Statement> getStatementById(String walletid);
	public List<Statement> getStatements();
	public void deleteById(String walletid);
	
}
