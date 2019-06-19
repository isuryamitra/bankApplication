package com.ibm.sf.dao;

import java.time.LocalDate;

public interface CustomerDAO {

	// login method
	public abstract Integer login(String uid,String password);

	
	//current available amount
	public abstract Double getCurrentAmount(String uid);
	//get customer statement
	public abstract String getStatement(String uid);
	//funds transfer
	public abstract Integer fundsTransfer(String name,Long accountno,Integer type,String ifsc,Double amount);
	//mobile topup
	public abstract Integer mobileTopUp(Long mobno,String operator,Double amount);
	//customer registration
	
	public abstract Integer customerReg(String name,Long accountno,String email,LocalDate dob,String fname,Long mobile,String password);
	//customer details
	public abstract Integer getCustomerDetails();
	public abstract Double withdraw(String uid,Double amount);
	public abstract Double deposit(String uid,Double amount);
	
}
