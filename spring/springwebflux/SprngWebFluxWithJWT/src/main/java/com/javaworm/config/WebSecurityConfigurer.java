package com.javaworm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.javaworm.auth.AuthenticationManager;
import com.javaworm.auth.SecurityContextRepository;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfigurer {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private SecurityContextRepository securityContextRepository;

	@Bean
	public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
		return http.csrf().disable().formLogin().disable().httpBasic().disable()
				.authenticationManager(authenticationManager).securityContextRepository(securityContextRepository)
				.authorizeExchange().pathMatchers(HttpMethod.OPTIONS).permitAll().pathMatchers("/login").permitAll()
				.anyExchange().authenticated().and().build();

	}

}
