package ru.itis.springbootdemo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UploadController {

    @GetMapping("/pets/upload")
    @PreAuthorize("permitAll()")
    public String getPage(Authentication authentication, Model model){
        if(authentication!= null){
            model.addAttribute("authentication",authentication);
        }
       return  "upload";
    }
}
