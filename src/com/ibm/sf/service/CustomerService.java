package com.ibm.sf.service;

import java.sql.Date;
import java.time.LocalDate;

import com.ibm.sf.service.exception.BankException;

public interface CustomerService {

	// login method
	public abstract Boolean login(String uid,String password)throws BankException;
	public abstract Integer fundsTransfer(Integer type, Integer amount, Integer uid, Date d, String remarks) throws BankException;

	

	public abstract Double getCurrentAmount(String uid)throws BankException;
	//get customer statement
	public abstract String getStatement(String uid)throws BankException;
	
	//mobile topup
	public abstract Integer mobileTopUp(Long mobno,String operator,Double amount)throws BankException;
	//customer registration
	
	public abstract Integer customerReg(String name,Long accountno,String email,LocalDate dob,String fname,Long mobile,String password)throws BankException;
	//customer details
	public abstract Integer getCustomerDetails()throws BankException;
	public abstract Double withdraw(String uid,Double amount) throws BankException;
	public abstract Double deposit(String uid,Double amount)throws BankException;


	
	
}
