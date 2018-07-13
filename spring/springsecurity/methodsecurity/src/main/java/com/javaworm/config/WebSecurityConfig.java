package com.javaworm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user1 = User.withDefaultPasswordEncoder().username("abirkhan")
				.password("password").roles("USER").build();

		UserDetails user2 = User.withDefaultPasswordEncoder().username("admin")
				.password("password").roles("ADMIN").build();
		
		UserDetails user3 = User.withDefaultPasswordEncoder().username("khan")
				.password("password").roles("VIEWER").build();

		return new InMemoryUserDetailsManager(user1, user2, user3);
	}

}
