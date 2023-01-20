package com.ssia.ch1.ex1.s1.model;

import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

@Entity
public class MyOtp {
	
	@Id
	private String username;
	private String code;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
