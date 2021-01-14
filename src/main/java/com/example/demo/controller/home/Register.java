package com.example.demo.controller.home;

import com.example.demo.model.entities.Role;
import com.example.demo.model.entities.User;
import com.example.demo.model.services.interface_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class Register {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public String create(User user){
        if(user.getPhoto().equals("")){
            user.setPhoto(null);
        }

        user.setCreatedDate(Date.valueOf(LocalDate.now()));

        List<Role> roles = new ArrayList<>();
        roles.add(new Role(2,"ROLE_USER"));
        user.setRoles(roles);

        userService.save(user);
        return "redirect:/login";
    }

}
