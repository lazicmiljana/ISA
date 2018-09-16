package com.ftn.isa.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.cinema.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	List<Movie> findByCinemaMovieId(long id);

}
