package com.examPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.examPortal.entity.UserEnt;
import com.examPortal.service.ResultService;
import com.examPortal.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private ResultService resultService;

	@RequestMapping(value = "/Login1", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid User!");
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("Login");

		return model;
	}

	@GetMapping(path = "/Home")
	public ModelAndView Home(Model model) {
		resultService.getUserResults(model);
		return new ModelAndView("user");
	}

	@GetMapping(path = "/Processing")
	public ModelAndView PlaylistLoad() {
		return new ModelAndView("Processing");
	}

	@GetMapping(path = "/Logout")
	public ModelAndView Logout() {
		return new ModelAndView("Login");
	}

	@GetMapping(path = "/Register")
	public ModelAndView RegistrationPage() {
		return new ModelAndView("/register");
	}

	@ModelAttribute("User")
	public UserEnt createModel() {
		return new UserEnt();
	}

	@PostMapping(path = "/newUserReg")
	public ModelAndView Registration(@ModelAttribute("User") UserEnt user, Model model) {
		System.out.println("sucessfull....");
		String msg = "";
		user.setUsername(user.getUsername());
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		msg = userService.addUser(user);
		if (msg.equals("REGISTERED SUCCESSFULLY")) {
			return new ModelAndView("/registrationSuccess");
		} else {
			model.addAttribute("message", msg);
			return new ModelAndView("/register");
		}
	}

}