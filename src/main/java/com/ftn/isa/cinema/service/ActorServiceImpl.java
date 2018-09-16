package com.ftn.isa.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.cinema.model.Actor;
import com.ftn.isa.cinema.repository.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	ActorRepository actorRepository;
	
	@Override
	public List<Actor> getAllActors() {
		return actorRepository.findAll();
	}

}
