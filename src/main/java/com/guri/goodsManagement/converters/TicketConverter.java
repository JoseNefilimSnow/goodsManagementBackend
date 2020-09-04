package com.guri.goodsManagement.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guri.goodsManagement.dto.TicketDto;
import com.guri.goodsManagement.entities.Ticket;

@Service
public class TicketConverter {
	@Autowired
	private ProductConverter productConv;

	public TicketDto convertFromEntityToDto(Ticket ticket) {
		TicketDto ticketDto = new TicketDto();
		ticketDto.setId(ticket.getId());
		ticketDto.setProducts(productConv.convertFromEntityListToDtoList(ticket.getProducts()));
		ticketDto.setTotalPrice(ticket.getTotalPrice());
		ticketDto.setTransactionDate(ticket.getTransactionDate());
		return ticketDto;
	}

	public Ticket convertFromDtoToEntity(TicketDto ticketDto) {
		Ticket ticket = new Ticket();
		ticket.setId(ticketDto.getId());
		ticket.setProducts(productConv.convertFromDtoListToEntityList(ticketDto.getProducts()));
		ticket.setTotalPrice(ticketDto.getTotalPrice());
		ticket.setTransactionDate(ticketDto.getTransactionDate());
		return ticket;
	}

	public List<TicketDto> convertFromEntityListToDtoList(List<Ticket> tickets) {
		List<TicketDto> ticketDtoList = new ArrayList<TicketDto>();
		for (Ticket ticket : tickets) {
			ticketDtoList.add(convertFromEntityToDto(ticket));
		}
		return ticketDtoList;
	}

	public List<Ticket> convertFromDtoListToEntityList(List<TicketDto> tickets) {
		List<Ticket> ticketList = new ArrayList<Ticket>();
		for (TicketDto ticket : tickets) {
			ticketList.add(convertFromDtoToEntity(ticket));
		}
		return ticketList;
	}

}
