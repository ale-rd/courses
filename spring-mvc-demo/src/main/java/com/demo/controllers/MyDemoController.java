package com.demo.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.Account;

@Controller
public class MyDemoController {
    
    private String[] quotes = {"A random quote 1", "quote 2", "quote 3"};
    
    // http://localhost:8080/springMVCDemo/getQuote.html
    @RequestMapping(value = "/getQuote")
    public String getRandomQuote(Model model) {
        
        int rand = new Random().nextInt(quotes.length);
        String randomQuote = quotes[rand];
        
        model.addAttribute("randomQuote", randomQuote);
        return  "quote";
    }
    
    @RequestMapping(value = "/createAccount")
    public String createAccount(@ModelAttribute("aNewAccount") Account account) {
        
        System.out.println(account.getFirstName() + " " + account.getLastName()
                       + " " + account.getAddress() + " " + account.getEmail());
        
        return "createAccount";
    }
    
}
