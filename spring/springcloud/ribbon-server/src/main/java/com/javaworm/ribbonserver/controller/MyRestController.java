package com.javaworm.ribbonserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
   
    @Autowired
    Environment environment;
    
    @GetMapping("/")
    public String applicationhealth(){
        return "I am working !";
    }
 
    @GetMapping("/hostport")
    public String serverbackend(){
 
        String serverPort = environment.getProperty("local.server.port");
        return "From Server backend!!" + " Host : localhost " + " :: Port : " + serverPort;
    }

}