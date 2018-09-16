package com.ftn.isa.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.cinema.model.Genre;
import com.ftn.isa.cinema.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	GenreRepository genreRepository;
	
	@Override
	public List<Genre> findAll() {
		return genreRepository.findAll();
	}

	@Override
	public Genre findById(long id) {
		return genreRepository.getOne(id);
	}

	
}
