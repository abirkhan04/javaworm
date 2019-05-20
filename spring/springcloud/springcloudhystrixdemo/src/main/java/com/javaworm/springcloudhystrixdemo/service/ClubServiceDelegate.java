package com.javaworm.springcloudhystrixdemo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ClubServiceDelegate {
	
	@Autowired
    RestTemplate restTemplate;
	
	
    @HystrixCommand(fallbackMethod = "callClubServiceAndGetData_Fallback")
    public String callClubServiceAndGetData(String clubname) {
 
        System.out.println("Getting School details for " + clubname);
 
        String response = restTemplate
                .exchange("http://localhost:8085/getClubDetails/{clubname}"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
            }, clubname).getBody();
 
        System.out.println("Response Received as " + response + " -  " + new Date());
 
        return "NORMAL FLOW !!! -Club Name -  " + clubname + " :::  " +
                    " Club Details " + response + " -  " + new Date();
    }
    
    @SuppressWarnings("unused")
    private String callClubServiceAndGetData_Fallback(String clubname) {
 
        System.out.println("Club Service is down!!! fallback route enabled...");
 
        return "CIRCUIT BREAKER ENABLED!!! No Response From Club Service at this moment. " +
                    " Service will be back shortly - " + new Date();
    }
 
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
}
