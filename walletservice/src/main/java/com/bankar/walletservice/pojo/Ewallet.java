package com.bankar.walletservice.pojo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Ewallet {
	
	@Id private String walletid;
	private Double currentBalance;
	private List<Statement> statements = new ArrayList<Statement>();

}
