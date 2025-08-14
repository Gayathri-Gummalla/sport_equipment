package com.example.Hack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @GetMapping("/")
    public String home() {
        return "home";  // loads home.html
    }

    @GetMapping("/adminlogin")
    public String showLoginForm() {
        return "adminlogin";  // loads adminlogin.html
    }

    @PostMapping("/adminlogin")
public String login(@RequestParam String username, 
                    @RequestParam String password, 
                    Model model) {
    if ("admin".equals(username) && "admin123".equals(password)) {
        return "redirect:/admin-dashboard";  // Redirect to admin dashboard if login is successful
    } else {
        // Redirect to /adminlogin with error message as a query parameter
        return "redirect:/adminlogin?error=true";
    }
}


    @GetMapping("/admin-dashboard")
    public String dashboard() {
        return "redirect:/admin-dashboard";  // loads admindashboard.html
    }
}