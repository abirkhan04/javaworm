package com.javaworm.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebFluxIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebFluxIntroApplication.class, args);

		 WebFluxClient wc = new WebFluxClient();
		 System.out.println(wc.getResult());
	}

}

