package com.example.demo.controller.dung;

import com.example.demo.model.entities.User;
import com.example.demo.model.services.interface_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getAll(Model model){
        List<User> userList = userService.getAll();
        model.addAttribute("userList",userList);
        return "dung/user";
    }

    @GetMapping("find/{id}")
    @ResponseBody
    public Optional<User> findById(@PathVariable("id")Integer id){
        return userService.findById(id);
    }

    @PostMapping("/update")
    public String save(User user){
        userService.save(user);
        return "redirect:/admin/user";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        userService.delete(id);
        return "redirect:/admin/user";
    }
}
