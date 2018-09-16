package com.ftn.isa.cinema.DTO;

import java.util.ArrayList;
import java.util.List;

import com.ftn.isa.cinema.model.Cinema;
import com.ftn.isa.cinema.model.CinemaType;
import com.ftn.isa.cinema.model.Hall;

import lombok.Data;


@Data
public class CinemaDTO {

	public CinemaDTO(Cinema cinema) {
		this.id = cinema.getId();
		this.name = cinema.getName();
		this.address = cinema.getAddress();
		this.promoDescription = cinema.getPromoDescription();
		this.cinemaTypeId = cinema.getCinemaType().getId();
	}
	
	public CinemaDTO() {}
	
	private long id;
	private String name;
	private String address;
	private String promoDescription;
	private double averageRate;
	private double numberOfVotes;
	private List<CinemaType> cinemaTypes;
	private long cinemaTypeId;
    private List<Hall> halls = new ArrayList<Hall>();
    
}
