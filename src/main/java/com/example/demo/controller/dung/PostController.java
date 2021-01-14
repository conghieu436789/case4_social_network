package com.example.demo.controller.dung;

import com.example.demo.model.entities.Post;
import com.example.demo.model.services.interface_services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/post")
public class PostController {
    @Autowired
    private PostService postService;


    @GetMapping
    public String getAll(Model model){
        List<Post> postList = postService.getAll();
        model.addAttribute("postList", postList);
        return "dung/post";
    }

    @GetMapping("find/{id}")
    @ResponseBody
    public Optional<Post> findById(@PathVariable("id")Integer id){
        return postService.findById(id);
    }

    @GetMapping("/searchTitle")
    public String findById(@RequestParam(value="titleSearch") String title, Model model){
        List<Post> postList = postService.findAllByTitle(title);
        model.addAttribute("postList", postList);
        return "dung/post";
    }


    @PostMapping("/update")
    public String save(Post post){
        postService.save(post);
        return "redirect:/admin/post";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        postService.delete(id);
        return "redirect:/admin/post";
    }
}
