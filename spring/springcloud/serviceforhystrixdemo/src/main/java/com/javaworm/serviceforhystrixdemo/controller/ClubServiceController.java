package com.javaworm.serviceforhystrixdemo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaworm.serviceforhystrixdemo.domain.Club;

@RestController
public class ClubServiceController {
	
	private static Map<String, List<Club>> clubDB = new HashMap<String, List<Club>>();	
    static {
        clubDB = new HashMap<String, List<Club>>();
        List<Club> lst = new ArrayList<Club>();
        Club gym1 = new Club("Kings", "Nikunja");
        lst.add(gym1);
        Club gym2 = new Club("Hammer", "Uttara");
        lst.add(gym2);
 
        clubDB.put("gym", lst);
 
        lst = new ArrayList<Club>();
        Club mclub1 = new Club("Jeetkunedo", "Dhaka");
        lst.add(mclub1);
        Club mclub2 = new Club("Khokshin", "Dhaka");
        lst.add(mclub2);
 
        clubDB.put("martial-arts", lst);
    }
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
    	return "Hello from Hystrix Demo Application";
    }
    
    
    @RequestMapping(value = "/getClubDetails/{clubname}", method = RequestMethod.GET)
    public List<Club> getClubs(@PathVariable String clubname) {
        System.out.println("Getting Student details for " + clubname);
 
        List<Club> clubList = clubDB.get(clubname);
        if (clubList == null) {
            clubList = new ArrayList<Club>();
            Club std = new Club("Not Found", "N/A");
            clubList.add(std);
        }
        return clubList;
    }
}
