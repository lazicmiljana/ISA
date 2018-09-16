package com.ftn.isa.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.cinema.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
	
	User findByEmailAndPassword(String email, String password);
}
