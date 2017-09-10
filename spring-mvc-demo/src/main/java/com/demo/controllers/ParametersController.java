package com.demo.controllers;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParametersController {
    
    private String[] quotes = {"A","B","C","D"};
    
    // !from: only works if there's not a from parameter.
    // from = Keisha: Only works if the parameter from is set to Keisha.
    @RequestMapping(value = "/getAnotherQuote", params="from=Keisha")
    public String getAnotherQuote(Model model){
        
        System.out.println("URL Mapped successfully");
        String randomQuote = generateRandomQuote();
        model.addAttribute("randomQuote", randomQuote);
        
        return "quote";
    }
    
    // "X-API-KEY=654321" requiere el header X-API-KEY con el valor específico 654321.
    @RequestMapping(value = "/getUltraQuote", headers="X-API-KEY=654321")
    public String getQuoteOnlyIfHeaderIsPresent(Model model){
        model.addAttribute("randomQuote", this.generateRandomQuote());
        return "quote";
    }
    @RequestMapping(value = "/getQuoteUsingParameter")
    public String getQuoteUsingParameter(@RequestParam("userName") String userName, Model model){
        
        System.out.println("/getQuoteUsingParameter called");
        
        String randomQuote = generateRandomQuote();
        model.addAttribute("randomQuote", randomQuote);
        
        System.out.println("User name is: " + userName);
        model.addAttribute("userName", userName);
        
        return "quote";
        
    }

    private String generateRandomQuote() {
        int randomNumber = new Random().nextInt(quotes.length);
        String randomQuote = quotes[randomNumber];
        return randomQuote;
    }
    

}
