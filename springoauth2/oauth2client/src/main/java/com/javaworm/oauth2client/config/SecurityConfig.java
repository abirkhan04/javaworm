package com.javaworm.oauth2client.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends
     WebSecurityConfigurerAdapter  {
	
	   @Override
	    protected void configure(HttpSecurity http)
	        throws Exception {
	        http.antMatcher("/**")
	            .authorizeRequests()
	            .antMatchers("/", "/webjars/**")
	            .permitAll()
	            .anyRequest()
	            .authenticated()
	            .and()
	            .logout()
	            .logoutSuccessUrl("/")
	            .permitAll()
	            .and()
	            .csrf()
	            .csrfTokenRepository(
	                CookieCsrfTokenRepository
	                    .withHttpOnlyFalse());
	}
	
	
	
	
	@Bean
	public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext oauth2ClientContext,
	        OAuth2ProtectedResourceDetails details) {
	    return new OAuth2RestTemplate(details, oauth2ClientContext);
	}

}
