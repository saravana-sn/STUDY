package com.saravana.mvcwebdemo.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saravana.mvcwebdemo.service.CustomUserDetailsService;

@Controller
public class GreetingController {

    private final CustomUserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    public GreetingController(CustomUserDetailsService userDetailsService, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/greet")
    public String greet(Model model) {
        // Get the authenticated user's username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.println("Username from context "+username);

        // Add the username to the model
        model.addAttribute("username", username);

        // Return the Thymeleaf template name
        return "greet";
    }
    @GetMapping("/home")
    public String homepage(Model model) {
        // Get the authenticated user's details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Check if the user is authenticated
        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            // Redirect to the login page if the user is not authenticated
            return "redirect:/login";
        }
        // Get the username
        String username = authentication.getName();
        model.addAttribute("username", username);
        // Get the user's role
        String role = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("ROLE_STAFF"); // Default role if no authority is found
        // Redirect to the appropriate page based on the role
        if (role.equals("ROLE_ADMIN")) {
            return "admin"; // Return the admin.html template
        } else {
            return "viewer"; // Return the viewer.html template
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Returns the login.html template
    }

    @GetMapping("/register1")
    public String register() {
        return "register"; // Returns the register.html template
    }

    // POST endpoint to handle user registration and auto-login
    @PostMapping("/register1")
    public String registerUser(
            @RequestParam String username, // Username from the form
            @RequestParam String password, // Password from the form
            @RequestParam String role
    ) {
        // Register the user by storing their details in the HashMap
        try {
            userDetailsService.registerUser(username, password, role);
        } catch (Exception userExistsAlready) {
            // Redirect to the /register endpoint
            return "redirect:/register?error";
        }

        // Authenticate the user programmatically
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        // Set the authentication in the SecurityContext
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Redirect to the /login endpoint
        return "redirect:/login?success";
    }
}
