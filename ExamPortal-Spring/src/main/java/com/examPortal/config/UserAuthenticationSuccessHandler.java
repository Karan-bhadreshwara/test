package com.examPortal.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.examPortal.entity.UserEnt;
import com.examPortal.service.UserService;

@Component
public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private UserService userService;

	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Authentication authentication) throws IOException, ServletException {
		HttpSession session = httpServletRequest.getSession();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		UserEnt user = userService.findByUsername(userName);
		Integer userId = user.getUserId();
		System.out.println(userName + "-" + userId);
		session.setAttribute("USER", user);
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		httpServletResponse.sendRedirect("/Processing");

	}
}