package com.demo.controllers;

import java.io.FileOutputStream;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.demo.model.Account;

/*
 * aNewAccount será un atributo de sesión y perdurará en el modelo mientras ésta dure.
 */
@Controller
@SessionAttributes("aNewAccount")
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
        
        System.out.println("Model updated with random quote.");
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
    
    @RequestMapping(value = "/doCreate")
    public String doCreate(@ModelAttribute("aNewAccount") Account account) {
        System.out.println("Do create - New account info - " + account.toString());
        System.out.println("Do create - Going off and creating an actual account.");
        return "redirect:accConfirm";
    }
    
    @RequestMapping(value = "/accConfirm")
    public String accountConfirmation(@ModelAttribute("aNewAccount") Account account ) {
        System.out.println("Account confirmed - " + account.toString());
        return "accountConfirmed";
    }
    
    @RequestMapping(value = "/accountCreated", method=RequestMethod.POST)
    public String performCreate(Account account) {
        System.out.println(account.toString());
        return "accountCreated";
    }
    
    @RequestMapping(value="/myForm")
    public String myForm() {
        return "myForm";
    }
    
    @RequestMapping(value = "/handleForm")
    public String handleForm(@RequestParam("file") MultipartFile file){
        try {
            if(!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                FileOutputStream fos = new FileOutputStream("D:\\Users\\aruizdia\\Desktop\\temp\\spring\\myFile.jpg");
                fos.write(bytes);
                fos.close();
                System.out.println("File successfully saved.");
            }
            
        }catch(Exception e) {
            System.out.println("Errror saving the file: " + e.getLocalizedMessage());
        }
        return "operationComplete"; 
    }
    
    /**
     * Agrega el atributo userName al modelo.
     * 
     * Se ejecuta antes que cualquier method handler de este controller.
     * 
     */
//    Lo dejo comentado a modo de ejemplo.
//    @ModelAttribute
//    public void setUserDetails(@RequestParam("userName") String userName, Model model) {
//        model.addAttribute("userName", userName);
//        
//        // Simulate going off and retrieving role based on userName
//        String userRole = "undefined";
//        if("Andy".equals(userName)) {
//            userRole = "Student";
//            
//        }else if("Jhon".equals(userName)) {
//            userRole = "Teacher";
//            
//        }else if("Allana".equals(userName)) {
//            userRole = "Dean";
//        }
//        
//        model.addAttribute("userRole", userRole);
//    }
    
    /**
     * 
     */
    @ModelAttribute
    public void addAccountToModel(Model model) {
        System.out.println("Making sure account object is on model ");
        if(!model.containsAttribute("aNewAccount")) {
            Account a = new Account();
            model.addAttribute("aNewAccount", a);
        }
    }
}
