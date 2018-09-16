package com.ftn.isa.cinema.controller;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ftn.isa.cinema.DTO.MovieDTO;
import com.ftn.isa.cinema.model.Actor;
import com.ftn.isa.cinema.model.Cinema;
import com.ftn.isa.cinema.model.Genre;
import com.ftn.isa.cinema.model.Movie;
import com.ftn.isa.cinema.service.ActorService;
import com.ftn.isa.cinema.service.CinemaService;
import com.ftn.isa.cinema.service.GenreService;
import com.ftn.isa.cinema.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	CinemaService cinemaService;
	
	@Autowired
	GenreService genreService;
	
	@Autowired
	ActorService actorService;
	
	@RequestMapping(value="/movies", method=RequestMethod.GET)
	public ModelAndView voteCinema(@RequestParam(value="id") Integer id, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		session.setAttribute("cinemaId", id);
		
		List<Movie> movies = movieService.getMoviesByCinemaId(id);
		
	    modelAndView.addObject("movies", movies);
	    modelAndView.setViewName("movies");
	    return modelAndView;
	}
	
	@RequestMapping(value="/movies/add", method=RequestMethod.GET)
	public ModelAndView addMovie(@RequestParam(value="cinemaId") Integer cinemaId) {
		ModelAndView modelAndView = new ModelAndView();
		
		MovieDTO movie = new MovieDTO();
		movie.setGenres(genreService.findAll());
		movie.setActors(actorService.getAllActors());
		
	    modelAndView.addObject("movie", movie);
	    modelAndView.setViewName("addMovie");
	    return modelAndView;
	}
	
	@RequestMapping(value="/movies/add", method=RequestMethod.POST)
	public ModelAndView addMovie(MovieDTO movie, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		long id = Long.parseLong(session.getAttribute("cinemaId").toString());
		Cinema cinema = cinemaService.findById(1);
		Genre genre = genreService.findById(movie.getGenreId().getId());
		
		Movie newMovie = new Movie();
		if(movie.getId() > 0) {
			newMovie.setId(movie.getId());
		}
		newMovie.setName(movie.getName());
		newMovie.setGenreMovie(genre);
		newMovie.setCinemaMovie(cinema);
		newMovie.setDirector(movie.getDirector());
		newMovie.setLength(movie.getLength());
		newMovie.setDescription(movie.getDescription());
		newMovie.setTime(movie.getTime());
		newMovie.setPrice(movie.getPrice());
		newMovie.setPoster(movie.getPoster());
		newMovie.setRate(1);
		
		for(Actor actor: movie.getSelectedActorIds()) {
			List<Movie> listOfMovies = new ArrayList<Movie>();
			listOfMovies.add(newMovie);
			actor.setMovies(listOfMovies);
		}
		
		newMovie.setActors(movie.getSelectedActorIds());
		
		movieService.save(newMovie);
		
		List<Movie> movies = movieService.getMoviesByCinemaId(id);
		
	    modelAndView.addObject("movies", movies);
	    modelAndView.setViewName("movies");
	    return modelAndView;
	}
	
	@RequestMapping(value = "/movies/upload-file", method = RequestMethod.POST)
    public ModelAndView importFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		ModelAndView modelAndView = new ModelAndView();
		String saveDirectory = "c:/app/";
		File f = new File(saveDirectory);
		if(!f.exists()) {
			f.mkdir();
		}
		File convFile = new File(saveDirectory+file.getOriginalFilename());
		file.transferTo(convFile);
		
		MovieDTO movie = new MovieDTO();
		movie.setGenres(genreService.findAll());
		movie.setActors(actorService.getAllActors());
		movie.setPoster(convFile.getAbsolutePath());
		
	    modelAndView.addObject("movie", movie);
		modelAndView.setViewName("addMovie");
	    return modelAndView;
    } 
	
	@RequestMapping(value="/movies/delete", method=RequestMethod.GET)
	public ModelAndView deleteCinema(@RequestParam(value="id") Integer id, @RequestParam(value="cinemaId") Integer cinemaId) {
		ModelAndView modelAndView = new ModelAndView();
      
		movieService.deleteMovie(id);
		
		List<Movie> movies = movieService.getMoviesByCinemaId(cinemaId);
		
	    modelAndView.addObject("movies", movies);
	    modelAndView.setViewName("movies");
	    return modelAndView;
	}
	
	@RequestMapping(value="/movies/vote", method=RequestMethod.GET)
	public ModelAndView voteCinema(@RequestParam(value="id") Integer id) {
		ModelAndView modelAndView = new ModelAndView();
      
		Movie movie = movieService.findById(id);
		
	    modelAndView.addObject("movie", movie);
	    modelAndView.setViewName("voteMovie");
	    return modelAndView;
	}
	
	@RequestMapping(value="/movies/vote", method=RequestMethod.POST)
	public ModelAndView voteCinema(@RequestParam("id") long id, @RequestParam("rate") double rate, @RequestParam("cinemaId") Integer cinemaId) {
		ModelAndView modelAndView = new ModelAndView();
		
		Movie movie = movieService.findById(id);
		double currentRate = movie.getRate() + rate;
		
		DecimalFormat df = new DecimalFormat("#.##");
		String average = df.format(currentRate/2);
		movie.setRate(Double.parseDouble(average)); 
		
		movieService.save(movie);
      
		List<Movie> movies = movieService.getMoviesByCinemaId(cinemaId);
		
	    modelAndView.addObject("movies", movies);
	    modelAndView.setViewName("movies");
	    return modelAndView;
	}
	
	@RequestMapping(value="/movies/edit", method=RequestMethod.GET)
	public ModelAndView editMovie(@RequestParam(value="id") Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		
		Movie movie = movieService.findById(id);
		MovieDTO movieDTO = new MovieDTO(movie);
		movieDTO.setGenres(genreService.findAll());
		movieDTO.setActors(actorService.getAllActors());
		
		modelAndView.addObject("movie", movie);
	    modelAndView.setViewName("addMovie");
	    return modelAndView;
	}

}
