package com.ftn.isa.cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cinema_type")
public class CinemaType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cinema_type_id")
	private long id;
	
	@Column(name = "cinema_type")
	private String name;
	
}
