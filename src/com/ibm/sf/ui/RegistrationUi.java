package com.ibm.sf.ui;

import java.time.LocalDate;

public class RegistrationUi{
	
	private String userName;
	private Integer userId;
	private Long accountNum;
	private String emailId;
	private LocalDate createDate;
	private String fatherName;
	private Long mobileNum;
	private String password;
	private String confirmPassword;
	
	public RegistrationUi() {
		
	}

	public RegistrationUi(String userName, Integer userId, Long accountNum, String emailId, LocalDate createDate,
			String fatherName, Long mobileNum, String password, String confirmPassword) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.accountNum = accountNum;
		this.emailId = emailId;
		this.createDate = createDate;
		this.fatherName = fatherName;
		this.mobileNum = mobileNum;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Long getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Long getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "RegistrationUi [userName=" + userName + ", userId=" + userId + ", accountNum=" + accountNum
				+ ", emailId=" + emailId + ", createDate=" + createDate + ", fatherName=" + fatherName + ", mobileNum="
				+ mobileNum + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}
	
}

