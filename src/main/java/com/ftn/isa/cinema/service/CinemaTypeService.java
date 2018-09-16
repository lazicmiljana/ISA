package com.ftn.isa.cinema.service;

import java.util.List;

import com.ftn.isa.cinema.model.CinemaType;

public interface CinemaTypeService {

	List<CinemaType> getAll();
	
	CinemaType findById(long id);
}
