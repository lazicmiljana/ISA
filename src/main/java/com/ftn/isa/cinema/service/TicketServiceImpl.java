package com.ftn.isa.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.cinema.model.Ticket;
import com.ftn.isa.cinema.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;
	
	@Override
	public List<Ticket> findAllByMovieId(long id) {
		return ticketRepository.findByMovieTicketId(id);
	}

	@Override
	public Ticket findById(long id) {
		return ticketRepository.getOne(id);
	}

	@Override
	public void save(Ticket ticket) {
		ticketRepository.save(ticket);
	}

}
