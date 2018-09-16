package com.ftn.isa.cinema.service;

import java.util.List;

import com.ftn.isa.cinema.model.Movie;

public interface MovieService {

	List<Movie> getMoviesByCinemaId(long id);
	
	void save(Movie m);
	
	void deleteMovie(long id);
	
	Movie findById(long id);
}
