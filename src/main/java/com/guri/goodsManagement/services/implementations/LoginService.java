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


	public UserDto currentLoggedInUser(String username) {
		
		return new UserDto(userRepository.findByUsername(username));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User aux = userRepository.findByUsername(username);
		
		if (aux == null) {
			throw new UsernameNotFoundException("No se pudo encontrar el usuario");
		} else {
			System.out.println("usuario encontrado "+aux.toString());
			System.out.println("usuario convertido "+new UserDto(aux).toString());
			return new UserDto(aux);
		}
	}


}
