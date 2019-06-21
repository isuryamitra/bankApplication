package com.ibm.sf.ui;

import java.time.LocalDate;

public class AllCustomerUi {
	
	private String userName;
	private Long accountNum;
	private String ifscCode;
    private Integer status;
public AllCustomerUi() {
	
}
public AllCustomerUi(String userName, Long accountNum, String ifscCode, Integer status) {
	super();
	this.userName = userName;
	this.accountNum = accountNum;
	this.ifscCode = ifscCode;
	this.status = status;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public Long getAccountNum() {
	return accountNum;
}
public void setAccountNum(Long accountNum) {
	this.accountNum = accountNum;
}
public String getIfscCode() {
	return ifscCode;
}
public void setIfscCode(String ifscCode) {
	this.ifscCode = ifscCode;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
@Override
public String toString() {
	return "AllCustomerUi [userName=" + userName + ", accountNum=" + accountNum + ", ifscCode=" + ifscCode + ", status="
			+ status + "]";
}

}
