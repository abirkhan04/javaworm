package com.javaworm.springbootdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootdatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdatajpaApplication.class, args);
	}
	
}
