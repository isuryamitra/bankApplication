package com.ibm.sf.service;

import java.time.LocalDate;

import com.ibm.sf.service.exception.BankException;

public interface BankService {
	public abstract Integer login(String uid,String password) throws BankException;
	public abstract String getStatement(String uid) throws BankException;;
	public abstract Integer fundsTransfer(String name,Long accountno,Integer type,String ifsc,Double amount)throws BankException;;
	public abstract Integer mobileTopUp(Long mobno,String operator,Double amount)throws BankException;;
	public abstract Integer customerReg(String name,Long accountno,String email,LocalDate dob,String fname,Long mobile,String password)throws BankException;;
	public abstract Integer getCustomerDetails()throws BankException;;
	public abstract Double withdraw(Long accountno,Double amount)throws BankException;;
	public abstract Double deposit(Long accountno,Double amount)throws BankException;;

}
