package com.ftn.isa.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.cinema.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
