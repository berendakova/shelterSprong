package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootdemo.dto.PetDto;
import ru.itis.springbootdemo.models.Pet;
import ru.itis.springbootdemo.models.StatusPet;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.PetsRepository;
import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;
import ru.itis.springbootdemo.service.UsersService;

@Controller
public class PetProfileController {
    @Autowired
    private PetsRepository petsRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersService usersService;
    @PostMapping("/pets/{pet-id}")
    public String takeHome(Authentication authentication, Model model, @PathVariable("pet-id") Integer petId) {

        UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
        User user =  userDetails.getUser();
        Pet pet = petsRepository.findPetById(petId);

        pet.setStatus(StatusPet.IN_HAND);
        pet.setUser(user);
        petsRepository.save(pet);
        model.addAttribute("user",user);
        model.addAttribute("pet",pet);

        model.addAttribute("authentication",pet);

         return "shelter";
    }


        @GetMapping("/pets/{pet-id}")
    public String getPetPage(Authentication authentication, Model model, @PathVariable("pet-id") Integer petId) {
        if (authentication != null) {
            model.addAttribute("authentication", authentication);
        }
        Pet pet = petsRepository.findPetById(petId);
        model.addAttribute("pet", pet);
        String status = pet.getStatus().toString();
        model.addAttribute("statusPet",status);
        return "petProfile";
    }

}
