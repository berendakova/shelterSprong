package ru.itis.springbootdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PetsListController {


    @GetMapping("/pets")
    public String getPage(){
        return "petsList";
    }

}
