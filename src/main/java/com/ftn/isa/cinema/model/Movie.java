package com.ftn.isa.cinema.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movie_id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "length")
	private int length;
	
	@Column(name = "rate")
	private double rate;
	
	@Column(name = "poster")
	private String poster;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "time")
	private String time;
	
	@Column(name = "price")
	private double price;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_cinema")
    private Cinema cinemaMovie;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "fk_hall")
//    private Hall hall_movie;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_genre")
    private Genre genreMovie;
	
	@OneToMany(mappedBy = "movieTicket")
    private List<Ticket> tickets = new ArrayList<Ticket>();
	
	@ManyToMany(cascade = { CascadeType.REMOVE })
    @JoinTable(
        name = "Movie_Actor", 
        joinColumns = { @JoinColumn(name = "movie_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "actor_id") }
    )
    List<Actor> actors = new ArrayList<Actor>();
}
