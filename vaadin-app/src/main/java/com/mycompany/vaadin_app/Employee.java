package com.mycompany.vaadin_app;

public class Employee implements IEmployee{
	
	private String username;
	
	private String password;
	
	private int numberOfLoginClick;

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}


	public int numberOfLoginClick() {
		return numberOfLoginClick;
	}

	public void setNumberOfLoginClick(int numberOfLoginClick) {
		this.numberOfLoginClick = numberOfLoginClick;
	}
	
	

}
