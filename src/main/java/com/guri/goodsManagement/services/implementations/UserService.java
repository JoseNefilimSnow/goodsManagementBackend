package com.guri.goodsManagement.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guri.goodsManagement.converters.UserConverter;
import com.guri.goodsManagement.dto.UserDto;
import com.guri.goodsManagement.entities.User;
import com.guri.goodsManagement.repositories.UserRepository;
import com.guri.goodsManagement.services.interfaces.IUserService;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserConverter userConv;
	@Autowired
	private UserRepository userRep;
	
	@Override
	public List<UserDto> readAll() {
		
		return userConv.convertFromEntityListToDtoList(userRep.findAll());
	}

	@Override
	public UserDto readOne(Long id) {
		return userConv.convertFromEntityToDto(userRep.findById(id).get());
	}

	@Override
	public UserDto create(UserDto user) {
		userRep.save(userConv.convertFromDtoToEntity(user));
		return user;
	}


	@Override
	public UserDto update(Long id, UserDto user) {
		User oldUser = userRep.findById(id).get();
		oldUser.setUsername(user.getUsername());
		oldUser.setPassword(user.getPassword());
		oldUser.setPermission(user.getPermission());
		oldUser.setEnabled(user.isEnabled());
		userRep.save(oldUser);
		return userConv.convertFromEntityToDto(userRep.findById(id).get());
	}

	@Override
	public void delete(Long id) {
		userRep.deleteById(id);
	}


}
