package com.example.demo.controller.dung;

import com.example.demo.model.entities.Post;
import com.example.demo.model.entities.User;
import com.example.demo.model.services.interface_services.PostService;
import com.example.demo.model.services.interface_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;
    @GetMapping
    public String dashboard(Model model){
        List<Post> postList = postService.getAll();
        List<User> userList = userService.getAll();
        System.out.println("posts :"+postList.size());
        System.out.println("users :"+userList.size());

        model.addAttribute("numberPosts",postList.size());
        model.addAttribute("numberUsers",userList.size());

        return "dung/dashboard";
    }

    @GetMapping(value = {"/account","/profile"})
    public String error(){
        return "dung/404";
    }


}
