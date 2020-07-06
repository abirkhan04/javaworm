package com.javaworm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaworm.service.UserRoleService;

@RestController
public class MethodSecurityController {

	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping(value = "/test-username", method = RequestMethod.GET)
	public @ResponseBody String testEndpoint() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (userRoleService.isValidUsername(authentication.getName())) {
			return "username is present in the repository";
		} else {
			return "username is not present in the repository";
		}
	}

	@RequestMapping(value = "/test-unauthorized-user", method = RequestMethod.GET)
	public @ResponseBody String testAuthorizedUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		userRoleService.unAuthorizedForUserRole(authentication.getName());
		return "User is Authorized";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String homeEndpoint() {
		return "Hello From java-worm.com";
	}

}
