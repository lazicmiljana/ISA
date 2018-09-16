package com.ftn.isa.cinema.DTO;

import java.util.ArrayList;
import java.util.List;

import com.ftn.isa.cinema.model.Actor;
import com.ftn.isa.cinema.model.Cinema;
import com.ftn.isa.cinema.model.Genre;
import com.ftn.isa.cinema.model.Hall;
import com.ftn.isa.cinema.model.Movie;
import com.ftn.isa.cinema.model.Ticket;

import lombok.Data;

@Data
public class MovieDTO {

	public MovieDTO() {}
	public MovieDTO(Movie movie) {
		this.id = movie.getId();
		this.name = movie.getName();
		this.director = movie.getDirector();
		this.length = movie.getLength();
		this.rate = movie.getRate();
		this.poster = movie.getPoster();
		this.description = movie.getDescription();
		this.time = movie.getTime();
		this.price = movie.getPrice();
		if(movie.getCinemaMovie() != null) {
			this.cinemaMovie = movie.getCinemaMovie();
		}
		if(movie.getGenreMovie() != null) {
			this.genreId = movie.getGenreMovie();
		}
		if(movie.getActors() != null) {
			this.selectedActorIds = movie.getActors();
		}
	}
	
	private long id;	
	private String name;
	private String director;
	private int length;
	private double rate;
	private String poster;
	private String description;
	private String time;
	private double price;
    private Cinema cinemaMovie;
//    private Hall hall_movie;
    private List<Genre> genres;
    private List<Actor> actors;
    private List<Actor> selectedActorIds;
    private Genre genreId;
    private List<Ticket> tickets = new ArrayList<Ticket>();
}
