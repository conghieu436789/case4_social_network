package com.example.demo.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FriendController {

    @GetMapping("/friends")
    public String error(){
        return "hieu/friend";
    }
}
