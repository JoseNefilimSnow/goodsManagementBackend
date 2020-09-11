package com.guri.goodsManagement.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.guri.goodsManagement.dto.UserDto;
import com.guri.goodsManagement.entities.User;

@Service
public class UserConverter {
	PasswordEncoder passEnc = new BCryptPasswordEncoder();
	public UserDto convertFromEntityToDto(User user) {
		
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setEnabled(user.getEnabled());
		userDto.setPermission(user.getPermission());
		return userDto;
	}

	public User convertFromDtoToEntity(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setUsername(userDto.getUsername());
		user.setPassword(passEnc.encode(userDto.getPassword()));
		user.setEnabled(userDto.isEnabled());
		user.setPermission(userDto.getPermission());
		return user;
	}

	public List<UserDto> convertFromEntityListToDtoList(List<User> users) {
		List<UserDto> userDtoList = new ArrayList<UserDto>();
		for (User user : users) {
			userDtoList.add(convertFromEntityToDto(user));
		}
		return userDtoList;
	}

	public List<User> convertFromDtoListToEntityList(List<UserDto> users) {
		List<User> userList = new ArrayList<User>();
		for (UserDto user : users) {
			userList.add(convertFromDtoToEntity(user));
		}
		return userList;
	}

}
