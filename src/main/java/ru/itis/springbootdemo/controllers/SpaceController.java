package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springbootdemo.dto.PetDto;
import ru.itis.springbootdemo.models.StatusPet;
import ru.itis.springbootdemo.repositories.PetsRepository;
import ru.itis.springbootdemo.service.PetsService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SpaceController {
    @Autowired
    private PetsService petsService;

    @GetMapping("/space")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getPsge(Authentication authentication, Model model) {
        if(authentication!=null){
            model.addAttribute("authentication", authentication);
        }
        List<PetDto> pets = new ArrayList<>();
        List<PetDto> petsAll = petsService.getAllPets();
        for (int i = 0; i < petsAll.size(); i++) {
            if (petsAll.get(i).getStatus().equals(StatusPet.IN_HAND)){
                pets.add(petsAll.get(i));
            }
        }
        model.addAttribute("pets", pets);
        return "space";
    }
}
