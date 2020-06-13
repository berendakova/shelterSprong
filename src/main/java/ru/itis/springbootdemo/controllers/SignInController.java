package ru.itis.springbootdemo.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignInController {
    @GetMapping("/signIn")
    public String getSignInPage(Authentication authentication, ModelMap model, @RequestParam(value = "error", required = false) String error ) {
        if(error != null) {
            model.put("error", "USER_NOT_FOUND");
        }

        if(authentication == null) {
            return "sign_in";
        }
        else {
            model.addAttribute("authentication",authentication);
            return "redirect:/shelter";
        }
    }


}
