package com.ftn.isa.cinema.controller;

import java.text.DecimalFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ftn.isa.cinema.DTO.CinemaDTO;
import com.ftn.isa.cinema.model.Cinema;
import com.ftn.isa.cinema.model.CinemaType;
import com.ftn.isa.cinema.model.Hall;
import com.ftn.isa.cinema.repository.HallRepository;
import com.ftn.isa.cinema.service.CinemaService;
import com.ftn.isa.cinema.service.CinemaTypeService;

@Controller
public class CinemaController {

	@Autowired
	private CinemaService cinemaService;
	
	@Autowired
	CinemaTypeService cinemaTypeService;
	
	@Autowired
	HallRepository hallRepository;
	
	@RequestMapping(value= {"/", "/cinemas"}, method = RequestMethod.GET)
	public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView();
        
        List<Cinema> cinema = cinemaService.getAllCinemas();
        
        modelAndView.addObject("cinemas", cinema);
        modelAndView.setViewName("cinemas");
        return modelAndView;
    }
	
	@RequestMapping(value="/cinemas/add", method = RequestMethod.GET)
	public ModelAndView addCinema() {
		CinemaDTO cinema = new CinemaDTO();
        cinema.setCinemaTypes(cinemaTypeService.getAll());
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cinema", cinema);
        modelAndView.setViewName("addCinema");
        return modelAndView;
    }
	
	@RequestMapping(value="/cinemas/add", method = RequestMethod.POST)
	public ModelAndView addCinema(@Valid CinemaDTO cinemaDTO) {
        ModelAndView modelAndView = new ModelAndView();
        
        Cinema cinema = new Cinema();
        if(cinemaDTO.getId() > 0) {
        	cinema.setId(cinemaDTO.getId());
        }
        cinema.setName(cinemaDTO.getName());
        cinema.setAddress(cinemaDTO.getAddress());
        cinema.setPromoDescription(cinemaDTO.getPromoDescription());
        cinema.setAverageRate(1);
        CinemaType ct = cinemaTypeService.findById(cinemaDTO.getCinemaTypeId());
        cinema.setCinemaType(ct);
        
        cinemaService.saveCinema(cinema);
        
//        Hall hall = new Hall();
//        hall.setCinema_hall(cinema);
//        hall.setName("Hall1");
//        hallRepository.save(hall);
        
        List<Cinema> cinemas = cinemaService.getAllCinemas();
        
	    modelAndView.addObject("cinemas", cinemas);
	    modelAndView.setViewName("cinemas");
        return modelAndView;
    }
	
	@RequestMapping(value="/cinemas/edit", method=RequestMethod.GET)
	public ModelAndView editCinema(@RequestParam(value="id") Integer id) {
		ModelAndView modelAndView = new ModelAndView();
      
		Cinema cinema = cinemaService.findById(id);
		CinemaDTO cinemaDTO = new CinemaDTO();
		
		cinemaDTO.setId(cinema.getId());
		cinemaDTO.setName(cinema.getName());
		cinemaDTO.setAddress(cinema.getAddress());
		cinemaDTO.setPromoDescription(cinema.getPromoDescription());
		cinemaDTO.setCinemaTypes(cinemaTypeService.getAll());
		cinemaDTO.setCinemaTypeId(cinema.getCinemaType().getId());
		
        modelAndView.addObject("cinema", cinemaDTO);
        modelAndView.setViewName("addCinema");
        
        return modelAndView;
	}
	
	@RequestMapping(value="/cinemas/delete", method=RequestMethod.GET)
	public ModelAndView deleteCinema(@RequestParam(value="id") Integer id) {
		ModelAndView modelAndView = new ModelAndView();
      
		cinemaService.deleteCinema(id);
		
		List<Cinema> cinema = cinemaService.getAllCinemas();
      
	    modelAndView.addObject("cinemas", cinema);
	    modelAndView.setViewName("cinemas");
	    return modelAndView;
	}
	
	@RequestMapping(value="/cinemas/vote", method=RequestMethod.GET)
	public ModelAndView voteCinema(@RequestParam(value="id") Integer id) {
		ModelAndView modelAndView = new ModelAndView();
      
		Cinema cinema = cinemaService.findById(id);
		
	    modelAndView.addObject("cinema", cinema);
	    modelAndView.setViewName("voteCinema");
	    return modelAndView;
	}
	
	@RequestMapping(value="/cinemas/vote", method=RequestMethod.POST)
	public ModelAndView voteCinema(@RequestParam("id") long id, @RequestParam("averageRate") double averageRate) {
		ModelAndView modelAndView = new ModelAndView();
		
		Cinema cinema = cinemaService.findById(id);
		double currentRate = cinema.getAverageRate() + averageRate;
		
		DecimalFormat df = new DecimalFormat("#.##");
		String average = df.format(currentRate/2);
		cinema.setAverageRate(Double.parseDouble(average)); 
		
		cinemaService.saveCinema(cinema);
      
		List<Cinema> cinemas = cinemaService.getAllCinemas();
        
	    modelAndView.addObject("cinemas", cinemas);
	    modelAndView.setViewName("cinemas");
	    return modelAndView;
	}
}
