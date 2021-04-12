package com.bankar.walletservice.pojo;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Statement {
	
	@Id private String statementid;
	private String transactionType;
	private Double amount;
	private LocalDateTime dateTime = LocalDateTime.now();
	private String orderid;
	private String transactionRemarks;

}
