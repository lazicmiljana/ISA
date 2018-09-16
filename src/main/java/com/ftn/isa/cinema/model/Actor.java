package com.ftn.isa.cinema.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "actor")
public class Actor {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;
	
	@Column(name = "name")
    private String name;
	
	@ManyToMany(mappedBy = "actors", cascade = CascadeType.REMOVE)
    private List<Movie> movies = new ArrayList<Movie>();
}
