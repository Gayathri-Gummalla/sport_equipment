package com.example.Hack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Hack.model.User;
import com.example.Hack.repo.UserRepository;

@Controller
public class Usercontroller {

    @Autowired
    private UserRepository userRepository;

    // Show dashboard after admin logs in
    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "admin-dashboard";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userRepository.findByUsername(username);
        
        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/home";  // Redirect to home page after successful login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";  // Return to login page with error message
        }
    }
}