package com.shorturltask.shortner;

public class User {

	private String accountID;
	private String password;
	
	public User(String accountID, String password) {
		this.accountID = accountID;
		this.password = password;
	}
	
	public User() {
		
	}
	
	public String getAccountID() {
		return accountID;
	}
	
	private Long getAccountIDLong() {
		return (long) Integer.parseInt(accountID);
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
