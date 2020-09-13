package com.examPortal.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examPortal.entity.UserEnt;


public interface UserRepository extends JpaRepository<UserEnt, Integer> {
	
	Optional<UserEnt> findByusername(String username);
	
}
