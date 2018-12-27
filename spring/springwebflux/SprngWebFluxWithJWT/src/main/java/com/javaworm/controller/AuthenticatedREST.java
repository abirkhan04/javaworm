package com.javaworm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaworm.model.AuthRequest;
import com.javaworm.model.AuthResponse;
import com.javaworm.service.UserService;
import com.javaworm.util.JWTUtil;
import com.javaworm.util.PassEncoder;

import reactor.core.publisher.Mono;

@RestController
public class AuthenticatedREST {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private PassEncoder passwordEncoder;

	@Autowired
	private UserService userRepository;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Mono<ResponseEntity<?>> login(@RequestBody AuthRequest ar) {
		return userRepository.findByUsername(ar.getUsername()).map((userDetails) -> {
			if (passwordEncoder.encode(ar.getPassword()).equals(passwordEncoder.encode(userDetails.getPassword()))) {
				return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails)));
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		}).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

}
