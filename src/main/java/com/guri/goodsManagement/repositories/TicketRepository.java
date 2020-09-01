package com.guri.goodsManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guri.goodsManagement.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
