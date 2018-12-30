package com.javaworm.config;

import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

@Component
public class Filter implements WebFilter {

	private Log logger = LogFactory.getLog(Filter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange swe, WebFilterChain chain) {

		ServerHttpRequest request = swe.getRequest();
		String authHeader = request.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE);

		logger.info("Content-type :" + authHeader);
		return chain.filter(swe);
	}
}
