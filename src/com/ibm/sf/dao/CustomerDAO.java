package com.ibm.sf.dao;

import java.time.LocalDate;
import java.util.List;

import com.ibm.sf.service.exception.BankException;

public interface CustomerDAO {

	// login method
	public abstract Integer login(String uid,String password)throws BankException;
	//reg
	public abstract Integer customerReg(String name,Long accountno,String email,LocalDate dob,String fname,Long mobile,String password)throws BankException;
	
	//current available amount
	public abstract Double getCurrentAmount(String uid)throws BankException;
	//get customer statement
	public abstract List getStatement(String uid)throws BankException;
	//funds transfer
	public abstract Integer fundsTransfer(String name,Long accountno,Integer type,String ifsc,Double amount)throws BankException;
	//mobile topup
	public abstract Integer mobileTopUp(Long mobno,String operator,Double amount)throws BankException;
	//customer registration
	
	
	//customer details
	public abstract List getCustomerDetails()throws BankException;
	public abstract Double withdraw(String uid,Double amount)throws BankException;
	public abstract Double deposit(String uid,Double amount)throws BankException;

	
}
