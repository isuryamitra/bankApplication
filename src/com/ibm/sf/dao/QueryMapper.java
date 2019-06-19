package com.ibm.sf.dao;

public interface QueryMapper {
	public static final String LOG_IN="select * from login_mast where user_id=? and pwd=?";
	public static final String CUST_REGISTER="insert into cust_register_mast values(?,?,?,?,?,?,?,?)";
	public static final String CUST_TRANSACT="insert into transact_mast values(?,?,?,?,?,?)";
	public static final String GET_IFSC="select * from ifsc_mast where branch_name=?";
	public static final String GET_CURRENTAMOUNT="select * from acc_mast where reg_id=?";
	
}
