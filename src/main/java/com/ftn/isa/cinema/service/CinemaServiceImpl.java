package com.ftn.isa.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.cinema.model.Cinema;
import com.ftn.isa.cinema.repository.CinemaRepository;

@Service
public class CinemaServiceImpl implements CinemaService {

	@Autowired
	private CinemaRepository cinemaRepository;
	
	@Override
	public List<Cinema> getAllCinemas() {
		List<Cinema> cinemas = cinemaRepository.findAll();
		
		return cinemas;
	}

	@Override
	public void deleteCinema(long id) {
		cinemaRepository.deleteById(id);
	}

	@Override
	public void saveCinema(Cinema cinema) {
		cinemaRepository.save(cinema);
	}

	@Override
	public Cinema findById(long id) {
		return cinemaRepository.getOne(id);
	}

}
