package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.springbootdemo.models.Pet;
import ru.itis.springbootdemo.repositories.PetsRepository;


@Controller
public class PetProfileController {
    @Autowired
    private PetsRepository petsRepository;

    @GetMapping("/pets/{pet-id}")
    @PreAuthorize("permitAll()")
    public String getPetPage(Authentication authentication, Model model, @PathVariable("pet-id") Integer petId) {
        if (authentication != null) {
            model.addAttribute("authentication", authentication);
        }
        Pet pet = petsRepository.findPetById(petId);
        model.addAttribute("pet", pet);
        String status = pet.getStatus().toString();
        model.addAttribute("statusPet", status);
        return "petProfile";
    }

}
