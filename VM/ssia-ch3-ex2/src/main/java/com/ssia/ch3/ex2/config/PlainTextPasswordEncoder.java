package com.ssia.ch3.ex2.config;

import java.security.MessageDigest;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PlainTextPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return hashWithSHA512(rawPassword.toString());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String hashedPassword = encode(rawPassword);
		return hashedPassword.equals(encodedPassword);
	}

	private String hashWithSHA512(String input) {
		StringBuilder result = new StringBuilder();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] digested = md.digest(input.getBytes());
			for(int i = 0 ; i <digested.length;i++) {
				result.append(Integer.toHexString(0xFF & digested[i]));				
			}
		} catch (Exception e) {
			throw new RuntimeException("Bad algorithm");			
		}
		return result.toString();
	}
}
