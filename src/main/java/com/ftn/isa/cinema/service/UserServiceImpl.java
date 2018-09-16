package com.ftn.isa.cinema.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.cinema.model.User;
import com.ftn.isa.cinema.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(User user) {
//		user.setPassword();
//        user.setActive(1);
//        Role userRole = roleRepository.findByRole("ADMIN");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findUserByEmailAndPassword(String email, String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
    	    md.update(password.getBytes());
    	    byte[] digest = md.digest();
    	    String hashPass = DatatypeConverter.printHexBinary(digest).toUpperCase();
			return userRepository.findByEmailAndPassword(email, hashPass);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
}
