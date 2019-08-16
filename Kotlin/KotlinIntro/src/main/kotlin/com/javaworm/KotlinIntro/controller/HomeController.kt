package com.javaworm.KotlinPractice1.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController {

  @GetMapping("/")
  fun blog(model: Model): String {
    model["title"] = "Hello World from Kotlin"
    return "blog"
  }

}

