package ru.itis.springbootdemo.controllers;


import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class ShelterController {
    @GetMapping("/shelter")
    public String getShelterPage(Authentication authentication, Model model) {
        if (authentication != null) {
            model.addAttribute("authentication", authentication);

        }
        String fact = getJSON("https://some-random-api.ml/facts/dog");
        String resonse = fact.substring(9, fact.length() - 3);

        model.addAttribute("joke", resonse);


        return "shelter";
    }

    public String getJSON(String urle) {
        try {
            URL url = new URL(urle);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-length", "0");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setConnectTimeout(30000);
            con.connect();
            int resp = con.getResponseCode();
            if (resp == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
                br.close();
                return sb.toString();
            } else {
                return "responseNull";
                /*Log.e("RESP", "Ответ сервера: " + resp);*/
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
