package com.demo.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParametersController {
    
    private String[] quotes = {"A","B","C","D"};
    
    // !from: only works if there's not a from parameter.
    // from = Keisha: Only works if the parameter from is set to Keisha.
    @RequestMapping(value = "/getAnotherQuote", params="from=Keisha")
    public String getAnotherQuote(Model model){
        
        System.out.println("URL Mapped successfully");
        int randomNumber = new Random().nextInt(quotes.length);
        String randomQuote = quotes[randomNumber];
        model.addAttribute("randomQuote", randomQuote);
        
        return "quote";
        
    }

}
