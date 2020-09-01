package com.guri.goodsManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.guri.goodsManagement.services.implementations.LoginService;
import com.guri.goodsManagement.dto.UserDto;

@RestController
public class LoginRestController {
	
	@Autowired
	public LoginService loginService;

	@GetMapping("/test")
	public void testConn() {
		System.out.println("TEST CONN ---------- ");
	}
	
	@GetMapping("/login")
	public UserDto login(@RequestHeader String username) {
		return loginService.currentLoggedInUser(username);
	}

}
