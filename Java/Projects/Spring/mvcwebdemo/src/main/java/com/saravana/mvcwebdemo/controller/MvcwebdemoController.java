package com.saravana.mvcwebdemo.controller;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.saravana.mvcwebdemo.model.RegistrationForm;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MvcwebdemoController {
    @GetMapping("/")
    public String home(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.println("Username from home "+username);
        model.addAttribute("message", "Hi, "+ username);
        return "index";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration";
    }

    @PostMapping("/register")
    public String handleRegistration(
            @Valid RegistrationForm registrationForm,
            BindingResult bindingResult,
            Model model
    ){
        if(bindingResult.hasErrors()){
            return "registration";
        }
        model.addAttribute("firstName", registrationForm.getFirstName());
        model.addAttribute("lastName", registrationForm.getLastName());
        model.addAttribute("country", registrationForm.getCountry());
        model.addAttribute("dob", registrationForm.getDob());
        model.addAttribute("email", registrationForm.getEmail());
        model.addAttribute("annualIncome", registrationForm.getAnnualIncome());

        return "success";
    }

    @GetMapping("/contactus")
    public String contact(){
        return "contactus";
    }
}
