package com.qa.hubspot.pojo;

public class Credentails {
	String emailId;
	String password;

	public Credentails(String emailId, String password) {
		
		this.emailId = emailId;
		this.password = password;
		
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
