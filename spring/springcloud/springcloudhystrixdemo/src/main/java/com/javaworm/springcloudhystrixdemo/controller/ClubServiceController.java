package com.javaworm.springcloudhystrixdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaworm.springcloudhystrixdemo.service.ClubServiceDelegate;

@RestController
public class ClubServiceController {
	
	@Autowired
	ClubServiceDelegate clubServiceDelegate;
	
    @RequestMapping(value = "/getClubDetails/{clubname}", method = RequestMethod.GET)
    public String getStudents(@PathVariable String clubname) {
        System.out.println("Going to call student service to get data!");
        return clubServiceDelegate.callClubServiceAndGetData(clubname);
    }

}
