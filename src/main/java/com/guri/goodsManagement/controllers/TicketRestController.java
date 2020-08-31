package com.guri.goodsManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guri.goodsManagement.dto.TicketDto;
import com.guri.goodsManagement.services.interfaces.ITicketService;

@RestController
public class TicketRestController {
	@Autowired
	private ITicketService ticketService;
	
	@GetMapping("/ticket")
	public List<TicketDto> readAll(){
		return ticketService.readAll();
	}
	
	@GetMapping("/ticket/{id}")
	public TicketDto readOne(@PathVariable Long id ) {
		return ticketService.readOne(id);
	}
	@PostMapping("/ticket")
	public TicketDto create(@RequestBody TicketDto ticket) {
		return ticketService.create(ticket);
	}
	@PutMapping("/ticket/{id}")
	public TicketDto update(@PathVariable Long id ) {
		return ticketService.update(id);
	}
	@DeleteMapping("/ticket/{id}")
	public TicketDto delete(@PathVariable Long id ) {
		return ticketService.delete(id);
	}
}
