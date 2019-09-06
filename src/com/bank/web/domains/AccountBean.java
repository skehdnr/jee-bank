package com.bank.web.domains;

import java.io.Serializable;

import lombok.Data;
@Data
public class AccountBean implements Serializable{
	private String regDate,accountNum,money;

	
}
