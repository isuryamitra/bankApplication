package com.ibm.sf.dao;

import java.time.LocalDate;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public Integer login(String uid, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getCurrentAmount(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStatement(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer fundsTransfer(String name, Long accountno, Integer type, String ifsc, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer mobileTopUp(Long mobno, String operator, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer customerReg(String name, Long accountno, String email, LocalDate dob, String fname, Long mobile,
			String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
