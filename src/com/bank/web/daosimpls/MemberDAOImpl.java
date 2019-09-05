package com.bank.web.daosimpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.pool.Constants;

public class MemberDAOImpl implements MemberDAO{
	
	@Override
	public void insertCustomer(CustomerBean param) {
		try {
			File file = new File(Constants.FILE_PATH+"customer20190905.txt");
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));	
			writer.write(String.format
					("%s,%s,%s,%s,%s", param.getId(),param.getPass(),param.getName()
							,param.getSsn(),param.getCredit()));
			writer.newLine();
			writer.flush();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertEmployee(EmployeeBean param) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public CustomerBean login(CustomerBean param) {
		try {
			String msg="";
			File file = new File(Constants.FILE_PATH+"customer20190905.txt");
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader (new FileReader(file));
			msg=reader.readLine();
			reader.close();
			String [] info = new String[5];
			info = msg.split(",");
			param.setId(info[0]);
			param.setPass(info[1]);
			param.setName(info[2]);
			param.setSsn(info[3]);
			param.setCredit(info[4]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return param;
	}

}
