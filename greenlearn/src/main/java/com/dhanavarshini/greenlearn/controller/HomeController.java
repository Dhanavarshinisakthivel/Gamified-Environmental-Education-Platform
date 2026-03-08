package com.dhanavarshini.greenlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
    
    @GetMapping("/memory")
    public String memoryGame(){
        return "memory";
    }
    
    @GetMapping("/waste")
    public String wasteGame(){
        return "waste";
    }

}