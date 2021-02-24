package com.example.demo.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/dangchothemsau")
    public String error(){
        return "hieu/404";
    }

}
