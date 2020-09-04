package com.guri.goodsManagement.services.interfaces;

import java.util.List;

import com.guri.goodsManagement.dto.TicketDto;

public interface ITicketService {

	List<TicketDto> readAll();

	TicketDto readOne(Long id);

	TicketDto create(TicketDto ticket);

	TicketDto update(Long id, TicketDto ticket);

	void delete(Long id);


}
