package com.ssia.ch2.ex1.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ssia.ch2.ex1.service.MyInMemoryUserDetailsService;
import com.ssia.ch2.ex1.user.MyUser;

@Configuration
public class ProjectConfig {
	
	@Bean
	public UserDetailsService userDetailService() {
		UserDetails u = new MyUser("asd","123","read");
		List<UserDetails> users = List.of(u);
		
		return new MyInMemoryUserDetailsService(users);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception{ http.httpBasic(); http.authorizeHttpRequests() .anyRequest() .a
	 * 
	 * 
	 * return http.build(); }
	 */
}
