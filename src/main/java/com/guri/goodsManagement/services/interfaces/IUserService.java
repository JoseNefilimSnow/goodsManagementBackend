package com.guri.goodsManagement.services.interfaces;

import java.util.List;

import com.guri.goodsManagement.dto.UserDto;

public interface IUserService {

	List<UserDto> readAll();

	UserDto readOne(Long id);

	UserDto create(UserDto user);

	UserDto update(Long id, UserDto user);

	void delete(Long id);

}
