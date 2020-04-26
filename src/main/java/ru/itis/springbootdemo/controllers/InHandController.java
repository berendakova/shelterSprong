package ru.itis.springbootdemo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class InHandController {

    @GetMapping("/inhand")
    public String getPage(Model model) {
        String[] imgs = getFiles();
        for (int i = 0; i < imgs.length; i++) {
            imgs[i] = "/img/upload/" + imgs[i];
        }
        model.addAttribute("img", imgs);
        return "inhand";
    }

    public String[] getFiles() {


        File folder = new File("src/main/resources/static/img/upload");
        String[] files = folder.list(new FilenameFilter() {
            @Override
            public boolean accept(File folder, String name) {
                return name.endsWith(".jpg");
            }
        });
        return files;
    }
}
