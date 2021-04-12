package com.bankar.walletservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankar.walletservice.pojo.Ewallet;
import com.bankar.walletservice.pojo.Statement;
import com.bankar.walletservice.repository.EwalletRepository;
import com.bankar.walletservice.repository.StatementsRepository;

@Service
public class EwalletServiceImpl implements EwalletService{
	
	@Autowired
	private EwalletRepository ewalletrepository;	
	
	@Autowired
	private StatementsRepository statementrepository;	
	
	

	public List<Ewallet> getWallets() {
		return ewalletrepository.findAll();
	}

	
	public Ewallet addEwallet(Ewallet ewallet) {
		return ewalletrepository.insert(ewallet);
	}

	
	public void addMoney(String walletid, double money) {
		Ewallet ewallet = ewalletrepository.findByWalletid(walletid);
		double newbalance = (ewallet.getCurrentBalance() + money);
		ewallet.setCurrentBalance(newbalance);		
	}
	

	public void update(String walletid,Ewallet ewallet) {
		ewalletrepository.save(ewallet);
	}
	

	public Ewallet getById(String walletid) {
		return ewalletrepository.findByWalletid(walletid);
	}

	
	public List<Statement> getStatementById(String walletid) {
		Ewallet ewallet = ewalletrepository.findByWalletid(walletid);
		return ewallet.getStatements();
	}
	

	public List<Statement> getStatements() {
		return statementrepository.findAll();
	}
	

	public void deleteById(String walletid) {
		ewalletrepository.deleteById(walletid);
	}

	
	
	
	
	
	
	
	
	
	
}
