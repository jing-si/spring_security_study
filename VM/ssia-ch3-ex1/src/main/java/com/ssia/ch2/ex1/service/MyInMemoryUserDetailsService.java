package com.ssia.ch2.ex1.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyInMemoryUserDetailsService implements UserDetailsService {
	
	private final List<UserDetails> users;
	
	public MyInMemoryUserDetailsService(List<UserDetails> users) {
		super();
		this.users = users;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		return users.stream()
				.filter(//사용자의 목록에서 요청된 사용자 이름과 일치하는 항목을 필터링 한다.
						u->u.getUsername().equals(username)
						)
				.findFirst() // 일치하는 사용자가 있으면 반환한다.
				.orElseThrow( // 일치하는 사용자가 없으면 예외를 투척한다.
						()-> new UsernameNotFoundException("User not found")
						);
	}

}
