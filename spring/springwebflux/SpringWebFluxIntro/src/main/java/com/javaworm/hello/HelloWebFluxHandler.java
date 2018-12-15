package com.javaworm.hello;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class HelloWebFluxHandler {
	public Mono<ServerResponse> hello(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
				.body(BodyInserters.fromObject("Hello, From Spring Web Flux!"));
	}

	public Mono<ServerResponse> hello1(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
				.body(BodyInserters.fromObject("Hello1, From Spring Web Flux!"));
	}

	public Mono<ServerResponse> hello2(ServerRequest request) {
		String name = request.queryParam("name").get();
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(BodyInserters.fromObject("Hello " + name));
	}

}
