/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.management.controllers;

import java.io.FileNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author PAUL
 */
@Controller
public class LoginController {
    public static final String CURRENT="select";
    
    @RequestMapping(value = "/welcome.htm", method = RequestMethod.GET)
    public String welcome(ModelMap model,HttpServletRequest request) throws FileNotFoundException {
        model.addAttribute(CURRENT,1);
        return "welcome";
    } 
    
    @RequestMapping(value = "/unauthorized.htm", method = RequestMethod.GET)
    public String unauthorized(ModelMap model,HttpServletRequest request) throws FileNotFoundException {
     model.addAttribute(CURRENT,1);
        return "unauthorized";
    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }
}
