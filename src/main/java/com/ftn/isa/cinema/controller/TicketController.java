package com.ftn.isa.cinema.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ftn.isa.cinema.model.Ticket;
import com.ftn.isa.cinema.model.User;
import com.ftn.isa.cinema.service.TicketService;
import com.ftn.isa.cinema.service.UserService;

@Controller
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/tickets", method=RequestMethod.GET)
	public ModelAndView viewTickts(@RequestParam(value="id") Integer id) throws ParseException {
		ModelAndView modelAndView = new ModelAndView();
		
		List<Ticket> tickets = ticketService.findAllByMovieId(id);
		
		modelAndView.addObject("tickets", tickets);
	    modelAndView.setViewName("tickets");
	    return modelAndView;
	}
	
	@RequestMapping(value="/tickets/reserve", method=RequestMethod.GET)
	public ModelAndView reserveTicket(@RequestParam(value="id") Integer id, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		
		Ticket ticket = ticketService.findById(id);
		String email = session.getAttribute("email").toString();
		User user = userService.findUserByEmail(email);
		
		ticket.setReserved(true);
		ticket.setUserTicket(user);
		
		ticketService.save(ticket);
		
		List<Ticket> tickets = ticketService.findAllByMovieId(ticket.getMovieTicket().getId());
		
		modelAndView.addObject("tickets", tickets);
	    modelAndView.setViewName("tickets");
	    return modelAndView;
	}

}
