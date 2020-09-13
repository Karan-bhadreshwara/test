package com.examPortal.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.examPortal.entity.UserEnt;
import com.examPortal.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public Optional<UserEnt> getUser(Integer id) {
		return userRepository.findById(id);
	}

	@Transactional
	public UserEnt findByUsername(String userName) {
		return userRepository.findByusername(userName).orElse(null);
	}

	@Transactional
	public String addUser(UserEnt user) {
		try {
			userRepository.save(user);
			return "REGISTERED SUCCESSFULLY";
		} catch (DataIntegrityViolationException e) {
			return "USERNAME ALREADY EXIST...!!!";
		}
	}

}