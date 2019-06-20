package com.ibm.sf.service;
import java.time.LocalDate;

import com.ibm.sf.dao.CustomerDAO;
import com.ibm.sf.dao.CustomerDAOImpl;
import com.ibm.sf.service.exception.BankException;
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customer=new CustomerDAOImpl();
	@Override
	public Integer login(String uid, String password) throws BankException {
		return customer.login(uid, password);
	}
	@Override
	public Integer customerReg(String name, Long accountno, String email, LocalDate dob, String fname, Long mobile,
			String password) throws BankException {
		return customer.customerReg(name, accountno, email, dob, fname, mobile, password);
	}
	@Override
	public Double getCurrentAmount(String uid) {
		return customer.getCurrentAmount(uid);
	}

	@Override
	public String getStatement(String uid) {
		return customer.getStatement(uid);
	}

	@Override
	public Integer fundsTransfer(String name, Long accountno, Integer type, String ifsc, Double amount) {
		return customer.fundsTransfer(name, accountno, type, ifsc, amount);
	}

	@Override
	public Integer mobileTopUp(Long mobno, String operator, Double amount) {
		return customer.mobileTopUp(mobno, operator, amount);
	}
	
	@Override
	public Integer getCustomerDetails() {
	return customer.getCustomerDetails();
	}

	
	@Override
	public Double withdraw(String uid, Double amount) throws BankException {
		return customer.withdraw(uid, amount);
	}

	@Override
	public Double deposit(String uid, Double amount) {
		return customer.deposit(uid, amount);
	}
}


