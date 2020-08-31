package com.guri.goodsManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {

	@GetMapping("/test")
	public void testConn() {
		System.out.println("TEST CONN ---------- ");
	}
	
//	@GetMapping("/login")
//	public UserDto login(@RequestHeader String username) {
//		
//	}

}
