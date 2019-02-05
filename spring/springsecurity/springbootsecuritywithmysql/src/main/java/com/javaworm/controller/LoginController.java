package com.javaworm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.logging.*;

import com.javaworm.model.User;
import com.javaworm.service.UserService;;

@Controller
public class LoginController {

	private static Logger logger = Logger.getLogger(LoginController.class.getName());

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info(auth.getName());
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		logger.info("User has authorities: " + userDetails.getAuthorities().toString());
		if (userDetails.getAuthorities().toString().equalsIgnoreCase("[ADMIN]")) {
			logger.info("Logged in as admin");
			return "redirect:/home/admin";
		} else {
			logger.info("Logged in as user");
			return "redirect:/home/user";
		}
	}

	@RequestMapping(value = "/home/user", method = RequestMethod.GET)
	public ModelAndView userhome() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info(auth.getName());
		modelAndView.setViewName("user/home");
		return modelAndView;
	}

	@RequestMapping(value = "/home/admin", method = RequestMethod.GET)
	public ModelAndView adminhome() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info(auth.getName());
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}

}
