package com.ibm.sf.dao;

public interface QueryMapper {
	public static final String VERIFY_USER="select * from login_master where user_id=? and password=?";
	public static final String NEW_USER_ID = null;

}
