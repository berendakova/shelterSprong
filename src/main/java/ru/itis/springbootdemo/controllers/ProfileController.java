package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springbootdemo.models.Pet;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.PetsRepository;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;

import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    PetsRepository petsRepository;

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String getProfile(Authentication auth, Model model){
        if(auth!=null){
            model.addAttribute("authentication",auth);
        }
        UserDetailsImpl userDetails = (UserDetailsImpl)auth.getPrincipal();
        User user =  userDetails.getUser();
        List<Pet> pets = petsRepository.findPetsByUserId(user.getId());
        model.addAttribute("pets",pets);
        return "profile";

    }
}
