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
@Table(name = "seat")
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seat_id")
	private long id;
	
	@Column(name = "row")
	private int row;
	
	@Column(name = "seat_number")
	private int number;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_hall")
    private Hall hall_seat;

	@OneToMany(mappedBy = "seat_ticket")
    private List<Ticket> tickets = new ArrayList<Ticket>();
}
