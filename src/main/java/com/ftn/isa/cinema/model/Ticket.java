package com.ftn.isa.cinema.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_id")
	private long id;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "time")
	private String time;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "discount")
	private int discount;
	
	@Column(name = "reserved")
	private boolean reserved;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_seat")
    private Seat seat_ticket;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_movie")
    private Movie movieTicket;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user")
    private User userTicket;
}
