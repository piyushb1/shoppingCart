package com.bankar.walletservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankar.walletservice.pojo.Ewallet;
import com.bankar.walletservice.pojo.Statement;
import com.bankar.walletservice.service.EwalletService;

@RestController
public class WalletResource {
	
	@Autowired
	private EwalletService ewalletservice;	
	
	
	
	@PostMapping("/add")
	public Ewallet addNew(@RequestBody Ewallet ewallet) {
		return ewalletservice.addEwallet(ewallet);
	}
	
	
	@GetMapping("/getAll")
	public List<Ewallet> getAllWallets(){
		return ewalletservice.getWallets();
		
	}
	
	
	@PutMapping("/addMoney/{walletid}")
	public void addMoney(@PathVariable String walletid,@RequestBody double money) {
		ewalletservice.addMoney(walletid,money);
	}
	
	
	@PutMapping("/update/{walletid}")
	public void update(@PathVariable String walletid,@RequestBody Ewallet ewallet) {
		ewalletservice.update(walletid,ewallet);
	}
	
	
	@GetMapping("/getById/{walletid}")
	public Ewallet getById(String walletid) {
		return ewalletservice.getById(walletid);
	}
	
	
	@GetMapping("/getStatementById/{walletid}")
	public List<Statement> getStatementById(String walletid){
		return ewalletservice.getStatementById(walletid);		
	}
	
	
	@GetMapping("/getStatementById")
	public List<Statement> getStatements(){
		return ewalletservice.getStatements();	
	}
	
	
	@GetMapping("/deleteById/{walletid}")
	public void deleteById(String walletid) {
		ewalletservice.deleteById(walletid);	
	}

}

















