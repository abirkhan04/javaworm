package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringSecurityHelloWorld {
    
    @RequestMapping("/welcome")
    public ModelAndView helloWorld() {
    String message = "Hello World";
    return new ModelAndView("welcome", "message", message);
    
  }
}
