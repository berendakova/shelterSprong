package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.UriComponentsBuilder;
import ru.itis.springbootdemo.dto.SignUpDto;
import ru.itis.springbootdemo.exceptions.NotCorrectSamePassword;
import ru.itis.springbootdemo.service.SignUpService;

@Controller
public class SignUpController {
    @Autowired
    private SignUpService service;

    @GetMapping("/signUp")
    public String getSignUpPage(Authentication authentication, Model model) {
        if(authentication == null) {
            return "sign_up";
        }
        else
        {
            model.addAttribute("authentication",authentication);
            return "redirect:/shelter";
        }

    }

    @PostMapping("/signUp")
    public String signUp(SignUpDto form, Model model) throws NotCorrectSamePassword {
        try {
            service.signUp(form);
        }
        catch (NotCorrectSamePassword e){
            model.addAttribute("message","parol");
            return "redirect:" + UriComponentsBuilder.fromPath("/signUp").build();
        }
        model.addAttribute("message"," ");
        return "redirect:/signIn";
    }
}
