package com.ftn.isa.cinema.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "cinema")
public class Cinema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cinema_id")
	private long id;
	
	@Column(name = "name")
	@NotEmpty(message = "*Please provide cinema name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "promo_description")
	private String promoDescription;
	
	@Column(name = "average_rate")
	@Min(value = 1, message = "Rate should not be less than 1")
    @Max(value = 5, message = "Rate should not be greater than 5")
	private double averageRate;
	
	@ManyToOne(optional = false)
    @JoinColumn(name="cinema_type_id")
	private CinemaType cinemaType;
	
//	@OneToMany(mappedBy = "cinema_hall")
//    private List<Hall> halls = new ArrayList<Hall>();
	
	@OneToMany(mappedBy = "cinemaMovie")
    private List<Movie> movies = new ArrayList<Movie>();
}
