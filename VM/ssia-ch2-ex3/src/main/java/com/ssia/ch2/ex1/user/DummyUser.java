package com.ssia.ch2.ex1.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;

public class DummyUser  implements UserDetails{
	private final String username;
	private final String password;
	
	public DummyUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(()->"READ");
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public UserDetails makeUserDetails() {
		UserBuilder builder1 = User.withUsername("builder1");
		UserDetails u1 = builder1
							.password("12345")
							.authorities("read","write")
							.passwordEncoder(p -> p)
							.accountExpired(false)
							.disabled(false)
							.build();
		return u1;
	}
}
