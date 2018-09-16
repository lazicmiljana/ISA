package com.ftn.isa.cinema.service;

import com.ftn.isa.cinema.model.User;

public interface UserService {

	void saveUser(User user);

	User findUserByEmail(String email);

	User findUserByEmailAndPassword(String email, String password);
}
