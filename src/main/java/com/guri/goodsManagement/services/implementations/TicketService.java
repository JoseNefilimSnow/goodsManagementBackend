package com.guri.goodsManagement.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guri.goodsManagement.converters.ProductConverter;
import com.guri.goodsManagement.converters.TicketConverter;
import com.guri.goodsManagement.dto.TicketDto;
import com.guri.goodsManagement.entities.Ticket;
import com.guri.goodsManagement.repositories.TicketRepository;
import com.guri.goodsManagement.services.interfaces.ITicketService;

@Service
public class TicketService implements ITicketService{
	@Autowired
	private TicketConverter ticketConv;
	@Autowired
	private TicketRepository ticketRep;
	@Autowired
	private ProductConverter productConv;
	
	@Override
	public List<TicketDto> readAll() {
		return ticketConv.convertFromEntityListToDtoList(ticketRep.findAll());
	}

	@Override
	public TicketDto readOne(Long id) {
		return ticketConv.convertFromEntityToDto(ticketRep.findById(id).get());
	}

	@Override
	public TicketDto create(TicketDto ticket) {
		ticketRep.save(ticketConv.convertFromDtoToEntity(ticket));
		return ticket;
	}


	@Override
	public TicketDto update(Long id, TicketDto ticket) {
		Ticket oldTicket = ticketRep.findById(id).get();
		oldTicket.setProducts(productConv.convertFromDtoListToEntityList(ticket.getProducts()));
		oldTicket.setTotalPrice(ticket.getTotalPrice());
		oldTicket.setTransactionDate(ticket.getTransactionDate());
		ticketRep.save(oldTicket);
		return ticketConv.convertFromEntityToDto(ticketRep.findById(id).get());
	}

	@Override
	public void delete(Long id) {
		ticketRep.deleteById(id);
	}


}
