package com.ftn.isa.cinema.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "genre")
public class Genre {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;
	
	@Column(name = "name")
    private String name;
	
	@OneToMany(mappedBy = "genreMovie")
    private List<Movie> movies = new ArrayList<Movie>();
	
}
