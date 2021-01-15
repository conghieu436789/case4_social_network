package com.example.demo.controller.home;

import com.example.demo.model.services.interface_services.PostService;
import com.example.demo.model.services.interface_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @GetMapping(value = {"/login"})
    public String login(Model model){
        model.addAttribute("user", getPrincipal());
        return "login";
    }

    //Cho` Anh Hieu
    @GetMapping(value = {"/", "/home"})
    public String Homepage(Model model){
        model.addAttribute("userList",userService.getAll());
        model.addAttribute("user", getPrincipal());
        model.addAttribute("posts",postService.getAll());
        return "hieu/home";
    }


    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

}
