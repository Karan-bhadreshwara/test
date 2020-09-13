package com.examPortal.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examPortal.entity.UserEnt;

@Service
public class UserInfoService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEnt user = userService.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException(username);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				Collections.singletonList(new SimpleGrantedAuthority("USER")));
	}

}
