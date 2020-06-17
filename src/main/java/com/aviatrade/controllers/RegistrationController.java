package com.aviatrade.controllers;

import com.aviatrade.validation.UserValidator;
import com.aviatrade.entity.User;
import com.aviatrade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {


    @Autowired
    private UserService usrService;

    @Autowired
    private UserValidator userValidator;


    @PostMapping("/register")
    public String login (@ModelAttribute(value = "newUser") User newUser, BindingResult bindingResult, Model model) {
        userValidator.validate(newUser, bindingResult);

         if(bindingResult.hasErrors()){
            model.addAttribute("invalidInput",true);
            return "login";
        }
         else if(usrService.isUserPresent(newUser.getUsername())){
            model.addAttribute("exists",true);
            return "login";
        }

            User response = usrService.saveUser(newUser);
            model.addAttribute("success",true);

        return "login";
    }

}
