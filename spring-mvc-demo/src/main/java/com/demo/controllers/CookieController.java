package com.demo.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
    
    /**
     * Sets a random cookie.
     * 
     * @param response
     * @return
     */
    @RequestMapping(value = "/addCookie")
    public String addCookie(HttpServletResponse response) {
        
        //Add a random cookie
        response.addCookie(new Cookie("myRandomCookie", "aCookieIAdded"));
        System.out.println("Cookie added");;
        
        return "demoPage";
    }
    
    @RequestMapping(value="/getCookie")
    public String getCookie(@CookieValue("myRandomCookie") String myCookie) {
        System.out.println("Cookie retrieved: " + myCookie);
        return "demoPage";
    }

}
