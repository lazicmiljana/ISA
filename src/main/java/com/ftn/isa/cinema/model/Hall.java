package com.ftn.isa.cinema.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "hall")
public class Hall {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hall_id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "fk_cinema")
//    private Cinema cinema_hall;
	
	@OneToMany(mappedBy = "hall_seat")
    private List<Seat> seats = new ArrayList<Seat>();
	
//	@OneToMany(mappedBy = "hall_movie")
//    private List<Movie> movies = new ArrayList<Movie>();
}
