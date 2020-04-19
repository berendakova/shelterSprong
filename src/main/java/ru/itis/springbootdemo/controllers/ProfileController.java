package ru.itis.springbootdemo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;
@Controller
public class ProfileController {
    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String getProfile(Authentication auth, Model model){
        UserDetailsImpl userDetails = (UserDetailsImpl)auth.getPrincipal();
        User user =  userDetails.getUser();
        model.addAttribute("user",user);
        return "profile";

    }
}
