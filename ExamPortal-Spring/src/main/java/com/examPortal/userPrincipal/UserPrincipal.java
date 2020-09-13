package com.examPortal.userPrincipal;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.examPortal.entity.UserEnt;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	private UserEnt user;

	public UserEnt getUser() {
		return user;
	}

	public void setUser(UserEnt user) {
		this.user = user;
	}

	public UserPrincipal() {
	}

	public UserPrincipal(UserEnt user) {
		super();
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	public String getPassword() {
		return user.getPassword();
	}

	public String getUsername() {
		return user.getUsername();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

}
