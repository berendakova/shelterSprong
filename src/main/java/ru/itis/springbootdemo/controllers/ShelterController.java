package ru.itis.springbootdemo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShelterController {
    @GetMapping("/shelter")
    public String getShelterPage(Authentication authentication){
        if(authentication !=  null){
            return "shelter";
        }
        else {
            return "redirect:/signIn";
        }

    }
}
