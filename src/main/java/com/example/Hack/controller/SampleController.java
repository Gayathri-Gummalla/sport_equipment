package com.example.Hack.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Hack.model.Sample;
import com.example.Hack.repo.SampleRepository;

@Controller
public class SampleController {

    @Autowired
    private SampleRepository sampleRepo;

    @PostMapping("/signup")
    public String signup(@RequestParam String email, @RequestParam String password) {
        Sample newUser = new Sample(email, password);
        sampleRepo.save(newUser);
        return "redirect:/login.html";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        Sample user = sampleRepo.findByEmailAndPassword(email, password);
        if (user != null) {
            return "redirect:/success.html";
        } else {
            return "redirect:/login.html?error=true";
        }
    }
}