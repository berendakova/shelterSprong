package ru.itis.springbootdemo.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {
    @GetMapping("/signIn")
    public String getSignInPage(Authentication authentication, Model model ) {
        if(authentication == null) {
            return "sign_in";
        }
        else {
            model.addAttribute("authentication",authentication);
            return "redirect:/shelter";
        }
    }

    @GetMapping("/logout")
    public String logout(Authentication authentication, Model model){
        model.addAttribute("authentication", null);
        return "redirect:/shelter";
    }
}
