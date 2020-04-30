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

import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.service.SignUpService;

@Controller
public class SignUpController {
    @Autowired
    private SignUpService service;
    @Autowired
    private UsersRepository usersRepository;
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
    public String signUp(SignUpDto form, Model model) {
        String errorExistingUser = "This user is also exist";
        String passwordError = "Your password not confirm";
        String nullError = "Fields can't be null";

        try {
            if(form.getPassword().equals("") || form.getEmail().equals("") || form.getName().equals("") || form.getRepeatedPassword().equals("")){
                model.addAttribute("nullError", nullError);
                return "sign_up";
            }
            if(usersRepository.findUserByEmail(form.getEmail()).isPresent()){
                model.addAttribute("errorExistingUser", errorExistingUser);
                return "sign_up";
            };
            if(!form.getPassword().equals(form.getRepeatedPassword())){
                model.addAttribute("passwordError",passwordError);
                return "sign_up";
            }
            service.signUp(form);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("message"," ");
        return "redirect:/signIn";
    }
}
