package com.ibm.sf.service;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.ibm.sf.dao.CustomerDAO;
import com.ibm.sf.dao.CustomerDAOImpl;
import com.ibm.sf.service.exception.BankException;
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customer=new CustomerDAOImpl();
	@Override
	public Boolean login(String uid, String password) throws BankException {
		return customer.login(uid, password);
	}
	/*
	 * @Override public abstract Integer fundsTransfer(Integer type, Integer amount,
	 * Integer uid, Date d, String remarks) throws BankException{ return
	 * customer.fundsTransfer(type, amount, uid, d, remarks); }
	 */
	@Override
	public Integer fundsTransfer(Integer type, Integer amount, Integer uid, Date d, String remarks)
			throws BankException {
		// TODO Auto-generated method stub
		return customer.fundsTransfer(type, amount, uid, d, remarks);
	}
	
	
	
	//TO BE UPDATED
	

@Override
	public Integer customerReg(String name, Long accountno, String email, LocalDate dob, String fname, Long mobile,
			String password) throws BankException {
		return customer.customerReg(name, accountno, email, dob, fname, mobile, password);
	}
	@Override
	public Double getCurrentAmount(String uid) throws BankException {
		return customer.getCurrentAmount(uid);
	}

	@Override
	public List getStatement(String uid) {
		return customer.getStatement(uid);
	}



	@Override
	public Integer mobileTopUp(Long mobno, String operator, Double amount) throws BankException {
		return customer.mobileTopUp(mobno, operator, amount);
	}
	
	@Override
	public List getCustomerDetails() {
	return customer.getCustomerDetails();
	}

	
	@Override
	public Double withdraw(String uid, Double amount) throws BankException {
		return customer.withdraw(uid, amount);
	}

	@Override
	public Double deposit(String uid, Double amount) throws BankException {
		return customer.deposit(uid, amount);
	}
	
}