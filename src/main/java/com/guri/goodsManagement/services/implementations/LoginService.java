package com.guri.goodsManagement.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.guri.goodsManagement.converters.UserConverter;
import com.guri.goodsManagement.dto.UserDto;
import com.guri.goodsManagement.entities.User;
import com.guri.goodsManagement.repositories.UserRepository;

@Service
public class LoginService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User aux =userRepository.findByUsername(username);

		if(aux.getEnabled()) {
			return userConverter.convertFromEntityToDto(userRepository.findByUsername(username));				
		}else {
			throw new UsernameNotFoundException("Usuario " + username + "bloqueado.");
		}
	}

	public UserDto currentLoggedInUser(String username) {
		
		return userConverter.convertFromEntityToDto(userRepository.findByUsername(username));
	}

}
