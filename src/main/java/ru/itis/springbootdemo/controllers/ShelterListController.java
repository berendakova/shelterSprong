package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springbootdemo.dto.PetDto;
import ru.itis.springbootdemo.dto.ShelterDto;
import ru.itis.springbootdemo.models.StatusPet;
import ru.itis.springbootdemo.service.ShelterService;

import java.util.ArrayList;
import java.util.List;

public class ShelterListController {

    @Autowired
    ShelterService shelterService;

    @GetMapping("/shelter/list")
    public String getPage(Authentication authentication, Model model){
        if(authentication != null){
            model.addAttribute("authentication", authentication);
            model.addAttribute("role",authentication.getAuthorities().toString());
        }

        List<ShelterDto> sheltersAll = shelterService.getAllShelter();

        model.addAttribute("shelters", sheltersAll);
        return "shelterList";
    }


}
