package com.gov.configuration.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Optional<String> getCurrentAuditor() {
//		return Optional.of(SecurityContextHolder.getContext().getAuthentication().getName());
//	}
//
	@Bean
	public AuditorAware<String> auditorProvider() {
		return () -> Optional.ofNullable("abir");
	}
}
