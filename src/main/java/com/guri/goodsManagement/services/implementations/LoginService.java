package com.guri.goodsManagement.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.guri.goodsManagement.dto.UserDto;
import com.guri.goodsManagement.repositories.UserRepository;
@Service
public class LoginService implements UserDetailsService{
	@Autowired
	private UserRepository userRep;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDto currentLoggedInUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}