package com.ftn.isa.cinema.service;

import java.util.List;

import com.ftn.isa.cinema.model.Ticket;

public interface TicketService {

	List<Ticket> findAllByMovieId(long id);
	
	Ticket findById(long id);
	
	void save(Ticket ticket);
}
