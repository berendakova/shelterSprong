package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import ru.itis.springbootdemo.dto.CreatedPetDto;
import ru.itis.springbootdemo.dto.PetDto;
import ru.itis.springbootdemo.dto.SignUpDto;

import ru.itis.springbootdemo.models.Pet;
import ru.itis.springbootdemo.models.StatusPet;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.PetsRepository;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;
import ru.itis.springbootdemo.service.CreatePetService;
import ru.itis.springbootdemo.service.PetsService;
import ru.itis.springbootdemo.service.UsersService;

import java.util.Optional;

@Controller
public class PetController {
    @Autowired
    private CreatePetService createPetService;

    @Autowired
    private PetsService petsService;

    @Autowired
    private PetsRepository petsRepository;

    @GetMapping("/pets/created")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getCreatedPage(Authentication authentication) {
        return "petFormCreate";

    }

    @PostMapping("/pets/created")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String createdHandler(CreatedPetDto form, Model model, Authentication authentication) {
        String nullField = "Fields can't be null";
        if (form.getAge().equals("") || form.getBreed().equals("") || form.getDescription().equals("") ||
                form.getName().equals("") || form.getImg().equals("") || form.getDisease().equals("") || form.getSex().equals("")
                || form.getSex().equals("Choosing...")) {

            model.addAttribute("nullEx", nullField);
            return "petFormCreate";
        }
        if (authentication != null) {
            model.addAttribute("authentication", authentication);
        }
        createPetService.created(form);
        return "shelter";
    }

    @PostMapping("/pets/{pet-id}/delete")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deletePet(@PathVariable("pet-id") Integer petId) {
        petsService.deletePet(petId);
        return "redirect:/shelter";
    }

    @GetMapping("/pets/{pet-id}/delete")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deletePetG(@PathVariable("pet-id") Integer petId) {
        petsService.deletePet(petId);
        return "redirect:/shelter";
    }

    @PostMapping("/pets/{pet-id}/take")
    public String takePets(@PathVariable("pet-id") Integer petId, Authentication authentication, ModelMap model) {

        if (authentication != null) {
            model.addAttribute("authentication", authentication);
        }
        assert authentication != null;
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();

        Pet pet = petsRepository.findPetById(petId);

        pet.setStatus(StatusPet.IN_HAND);
        pet.setUser(user);
        petsRepository.save(pet);

        model.addAttribute("user", user);
        model.addAttribute("pet", pet);

        return "redirect:/shelter";
    }

    @GetMapping("/pets/{pet-id}/take")
    public String takePet(@PathVariable("pet-id") Integer petId, Authentication authentication, ModelMap model) {

        if (authentication != null) {
            model.addAttribute("authentication", authentication);
        }
        assert authentication != null;
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();

        Pet pet = petsRepository.findPetById(petId);

        pet.setStatus(StatusPet.IN_HAND);
        pet.setUser(user);
        petsRepository.save(pet);

        model.addAttribute("user", user);
        model.addAttribute("pet", pet);

        return "redirect:/shelter";
    }

}
