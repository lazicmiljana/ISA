package com.ftn.isa.cinema.service;

import java.util.List;

import com.ftn.isa.cinema.model.Genre;

public interface GenreService {

	List<Genre> findAll();
	
	Genre findById(long id);
}
