package com.javaworm.service;

import java.util.Arrays;

import com.javaworm.model.Role;
import com.javaworm.model.User;

import reactor.core.publisher.Mono;

public class UserService {
	// username:passwowrd -> user:user
	private final String userUsername = "user";// password: user
	private final User user = new User(userUsername);

	// username:passwowrd -> admin:admin
	private final String adminUsername = "admin";// password: admin
	private final User admin = new User(adminUsername);

	public Mono<User> findByUsername(String username) {
		if (username.equals(userUsername)) {
			return Mono.just(user);
		} else if (username.equals(adminUsername)) {
			return Mono.just(admin);
		} else {
			return Mono.empty();
		}
	}

}
