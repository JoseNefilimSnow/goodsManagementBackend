package com.guri.goodsManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guri.goodsManagement.dto.UserDto;
import com.guri.goodsManagement.services.interfaces.IUserService;

@RestController
public class UserRestController {
	@Autowired
	private IUserService userService;

	@GetMapping("/user")
	public List<UserDto> readAll() {
		return userService.readAll();
	}

	@GetMapping("/user/{id}")
	public UserDto readOne(@PathVariable Long id) {
		return userService.readOne(id);
	}

	@PostMapping("/user")
	public UserDto create(@RequestBody UserDto user) {
		
		return userService.create(user);
	}

	@PutMapping("/user/{id}")
	public UserDto update(@PathVariable Long id,@RequestBody UserDto user) {
		return userService.update(id,user);
	}

	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}
}
