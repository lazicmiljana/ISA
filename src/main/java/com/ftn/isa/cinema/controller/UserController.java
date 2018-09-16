package com.ftn.isa.cinema.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ftn.isa.cinema.model.Cinema;
import com.ftn.isa.cinema.model.User;
import com.ftn.isa.cinema.repository.RoleRepository;
import com.ftn.isa.cinema.service.CinemaService;
import com.ftn.isa.cinema.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	CinemaService cinemaService;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session.getAttribute("email") != null) {
        	List<Cinema> cinema = cinemaService.getAllCinemas();
            
            modelAndView.addObject("cinemas", cinema);
            modelAndView.setViewName("cinemas");
            return modelAndView;
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findUserByEmailAndPassword(email, password);
        session.setAttribute("email", user.getEmail());
        session.setAttribute("role", user.getRole().getRole());
        if(user.getFirstLogin() == 1)
        {
        	modelAndView.addObject("user", user);
        	modelAndView.setViewName("changePassword");
        	return modelAndView;
        }
    	
    	List<Cinema> cinema = cinemaService.getAllCinemas();
        
        modelAndView.addObject("cinemas", cinema);
        modelAndView.setViewName("cinemas");
        return modelAndView;
    }

	@RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session.getAttribute("email") != null) {
        	List<Cinema> cinema = cinemaService.getAllCinemas();
            
            modelAndView.addObject("cinemas", cinema);
            modelAndView.setViewName("cinemas");
            return modelAndView;
        }
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult, HttpSession session) throws NoSuchAlgorithmException {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null && user.getId() == 0) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
        	if(user.getId() > 0) {
        		session.setAttribute("email", user.getEmail());
        		session.setAttribute("role", user.getRole().getRole());
        		
        		user.setFirstLogin(2);
        		userService.saveUser(user);
        		
        		List<Cinema> cinema = cinemaService.getAllCinemas();
                
                modelAndView.addObject("cinemas", cinema);
                modelAndView.setViewName("cinemas");
                return modelAndView;
        	}
        	user.setFirstLogin(1);
        	user.setRole(roleRepository.getOne((long) 1));
        	
        	MessageDigest md = MessageDigest.getInstance("MD5");
    	    md.update(user.getPassword().getBytes());
    	    byte[] digest = md.digest();
    	    String hashPass = DatatypeConverter.printHexBinary(digest).toUpperCase();
        	
        	user.setPassword(hashPass);
        	userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("login");
        }
        
        return modelAndView;
    }
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        session.setAttribute("email", null);
        session.setAttribute("role", null);
        modelAndView.setViewName("login");
        return modelAndView;
    }
	
	@RequestMapping(value="/change-password", method = RequestMethod.POST)
    public ModelAndView changePassword(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) throws NoSuchAlgorithmException{
        ModelAndView modelAndView = new ModelAndView();
        if(session.getAttribute("email") == null) {
        	List<Cinema> cinema = cinemaService.getAllCinemas();
            
            modelAndView.addObject("cinemas", cinema);
            modelAndView.setViewName("cinemas");
            return modelAndView;
        }
        User user = userService.findUserByEmail(email);
        user.setFirstLogin(2);
        
        MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(password.getBytes());
	    byte[] digest = md.digest();
	    String hashPass = DatatypeConverter.printHexBinary(digest).toUpperCase();
        
        user.setPassword(hashPass);
        
        userService.saveUser(user);
    	
    	List<Cinema> cinema = cinemaService.getAllCinemas();
        
        modelAndView.addObject("cinemas", cinema);
        modelAndView.setViewName("cinemas");
        return modelAndView;
    }
	
	@RequestMapping(value="/edit", method = RequestMethod.GET)
    public ModelAndView editUser(@RequestParam("email") String email, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(session.getAttribute("email") == null) {
        	List<Cinema> cinema = cinemaService.getAllCinemas();
            
            modelAndView.addObject("cinemas", cinema);
            modelAndView.setViewName("cinemas");
            return modelAndView;
        }
        User user = userService.findUserByEmail(email);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }
}
