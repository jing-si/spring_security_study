package com.ssia.ch2.ex1.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUser implements UserDetails {
	private final String username;
	private final String password;
	private final String authority; //예제를 간단히 하기 위해 권한은 하나만 있는 것으로
	
	public MyUser(String username, String password,String authority) {
		super();
		this.username = username;
		this.password = password;
		this.authority = authority; 
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(()->authority); //인스턴스를 만들 때 지정한 이름의 GrantedAuthority객체만 포함하는 목록을 반환한다.
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	//계정은 만료되거나 잠기지 않는다.
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
	

}
