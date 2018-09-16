package com.ftn.isa.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.cinema.model.Movie;
import com.ftn.isa.cinema.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public List<Movie> getMoviesByCinemaId(long id) {
		return movieRepository.findByCinemaMovieId(id);
	}

	@Override
	public void save(Movie m) {
		movieRepository.save(m);
	}

	@Override
	public void deleteMovie(long id) {
		movieRepository.deleteById(id);
	}

	@Override
	public Movie findById(long id) {
		return movieRepository.getOne(id);
	}

}
