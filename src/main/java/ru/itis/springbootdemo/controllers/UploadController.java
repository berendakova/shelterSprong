package ru.itis.springbootdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UploadController {

    @GetMapping("/pets/upload")
    public String getPage(){

       return  "upload";
    }
}
