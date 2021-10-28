package com.example.school.controllers;

import com.example.school.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class MainController {


    @GetMapping(path = "/")
    public String index(Map<String, Object> model){
        return "index";
    }

    @GetMapping(path = "/main")
    public String main() {
        return "main";
    }

    @GetMapping(path = "/admin")
    public String admin(){
        return "admin";
    }




}
