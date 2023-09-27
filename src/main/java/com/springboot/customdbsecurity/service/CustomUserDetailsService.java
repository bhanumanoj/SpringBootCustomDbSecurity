package com.springboot.customdbsecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.customdbsecurity.model.CustomUserDetails;
import com.springboot.customdbsecurity.model.Users;
import com.springboot.customdbsecurity.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Users> dbUserdata=repository.findByName(username);
		
		dbUserdata
			.orElseThrow(()-> new UsernameNotFoundException("username not found"));
		
		return dbUserdata
				.map(CustomUserDetails::new).get();
		
		
		
	}
	
}
