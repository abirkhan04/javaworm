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
	UserRoleService userRoleService;

	@RequestMapping(value = "/testusername", method = RequestMethod.GET)
	public @ResponseBody String testEndpoint() {

		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		String currentPrincipalName = authentication.getName();
		boolean isValid = userRoleService.isValidUsername(currentPrincipalName);
		if (isValid) {
			return "username is present in the repository";
		} else {
			return "username is not present in the repository";
		}
	}

	@RequestMapping(value = "/testunauthorizeduser", method = RequestMethod.GET)
	public @ResponseBody String testAuthorizedUser() {

		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		String currentPrincipalName = authentication.getName();
		userRoleService.unAuthorizedForUserRole(currentPrincipalName);

		return "User is authorized";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String homeEndpoint() {
		return "Hello From Javaworm.com";
	}

}