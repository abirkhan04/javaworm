package com.javaworm.crud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class WebFluxRouterCrud {

	@Bean
	public RouterFunction<ServerResponse> route(CRUDHandler handler) {
		return RouterFunctions
		  .route(RequestPredicates.GET("/persons").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
			handler::listPersons)
		  .andRoute(RequestPredicates.POST("/person").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
		    handler::insertPerson)
		  .andRoute(RequestPredicates.PUT("/person/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), 
			handler::updatePerson)
		  .andRoute(RequestPredicates.DELETE("/person/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), 
			handler::deletePerson);
	}

}
