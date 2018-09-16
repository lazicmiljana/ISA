package com.ftn.isa.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.cinema.model.Cinema;

@Repository("cinemaRepository")
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
	
}
