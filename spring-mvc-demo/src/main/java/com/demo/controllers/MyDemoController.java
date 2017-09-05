package com.demo.controllers;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.model.Account;

@Controller
public class MyDemoController {
    
    private String[] quotes = {"A random quote 1", "quote 2", "quote 3"};
    
    /**
     * Responde a una url http://localhost:8080/springMVCDemo/getQuote.html
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/getQuote")
    public String getRandomQuote(Model model) {
        
        int rand = new Random().nextInt(quotes.length);
        String randomQuote = quotes[rand];
        
        model.addAttribute("randomQuote", randomQuote);
        return  "quote";
    }
    
    /**
     * Crea una Account.
     * 
     * @param account
     * @param result
     * @return
     */
    @RequestMapping(value = "/createAccount")
    public String createAccount(@Valid @ModelAttribute("aNewAccount") Account account, BindingResult result) {
        
        System.out.println(account.getFirstName() + " " + account.getLastName()
                       + " " + account.getAddress() + " " + account.getEmail());
        
        if(result.hasErrors()) {
            System.out.println("Form has errors.");
            return "createAccount";
        }
        
        System.out.println(account.getFirstName() + " " + account.getLastName());
        return "createAccount";
    }
    
    @RequestMapping(value = "/accountCreated", method=RequestMethod.POST)
    public String performCreate(Account account) {
        System.out.println(account.toString());
        return "accountCreated";
    }
    
}
