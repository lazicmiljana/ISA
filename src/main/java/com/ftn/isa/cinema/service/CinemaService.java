package com.ftn.isa.cinema.service;

import java.util.List;

import com.ftn.isa.cinema.model.Cinema;

public interface CinemaService {
	
	List<Cinema> getAllCinemas();
	
	void saveCinema(Cinema cinema);
	
	void deleteCinema(long id);
	
	Cinema findById(long id);
	
}
