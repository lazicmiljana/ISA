package com.ftn.isa.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.cinema.model.CinemaType;
import com.ftn.isa.cinema.repository.CinemaTypeRepository;

@Service
public class CinemaTypeServiceImpl implements CinemaTypeService{

	@Autowired
	CinemaTypeRepository cinemaTypeRepository;
	
	@Override
	public List<CinemaType> getAll() {
		return cinemaTypeRepository.findAll();
	}

	@Override
	public CinemaType findById(long id) {
		return cinemaTypeRepository.getOne(id);
	}

}
