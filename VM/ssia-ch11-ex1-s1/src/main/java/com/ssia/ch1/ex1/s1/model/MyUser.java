package com.ssia.ch1.ex1.s1.model;

import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

@Entity
public class MyUser {
	
	@Id
	private String username;
	private String password;
	
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
	
	

}
