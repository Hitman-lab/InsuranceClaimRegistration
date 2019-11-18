package com.capg.model;

public class Accounts {
	private long accNo;
	private String incName;
	private String userName;

	public Accounts() {
	}

	public Accounts(long accNo, String incName, String userName) {
		super();
		this.accNo = accNo;
		this.incName = incName;
		this.userName = userName;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getIncName() {
		return incName;
	}

	public void setIncName(String incName) {
		this.incName = incName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Accounts [accNo=" + accNo + ", incName=" + incName + ", userName=" + userName + "]";
	}
}
