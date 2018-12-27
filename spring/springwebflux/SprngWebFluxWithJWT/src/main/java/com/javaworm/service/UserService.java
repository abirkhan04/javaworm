package com.javaworm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaworm.model.Role;
import com.javaworm.model.User;
import com.javaworm.util.PassEncoder;

import reactor.core.publisher.Mono;

@Service
public class UserService {

	// username:passwowrd -> user:user
	private final String userUsername = "user";// password: user
	private final String userPassword = "user";
	private final User user = new User(userUsername, userPassword);

	// username:passwowrd -> admin:admin
	private final String adminUsername = "admin";// password: admin
	private final String adminPassword = "admin";
	private final User admin = new User(adminUsername, adminPassword);

	public Mono<User> findByUsername(String username) {
		if (username.equals(userUsername)) {
			List<Role> roles = new ArrayList<Role>();
			roles.add(Role.ROLE_USER);
			user.setRoles(roles);
			return Mono.just(user);
		} else if (username.equals(adminUsername)) {
			List<Role> roles = new ArrayList<Role>();
			roles.add(Role.ROLE_ADMIN);
			user.setRoles(roles);
			return Mono.just(admin);
		} else {
			return Mono.empty();
		}
	}

}
