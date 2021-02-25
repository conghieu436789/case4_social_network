package com.example.demo.controller.home;

import com.example.demo.model.entities.Emote;
import com.example.demo.model.entities.Post;
import com.example.demo.model.entities.User;
import com.example.demo.model.services.interface_services.EmoteService;
import com.example.demo.model.services.interface_services.PostService;
import com.example.demo.model.services.interface_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
public class PostByUserController {

    @Autowired
    private PostService postService;

    @Autowired
    private EmoteService emoteService;

    @RequestMapping(value = "posting",method = RequestMethod.POST)
    public String createPost(Post post){
        post.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        postService.save(post);
        return "redirect:/home";
    }

    @PostMapping("/like")
    public String createLike(Emote emote){
        emoteService.save(emote);
        return "redirect:/home";
    }

    @PostMapping("/dislikePost")
    public String disLikePost(Emote emote){
        emoteService.disLikePost(emote.getUser_id(),emote.getPost_id());
        return "redirect:/home";
    }

    @PostMapping("/dislikeComment")
    public String disLikeComment(Emote emote){
        emoteService.disLikePost(emote.getUser_id(),emote.getComment_id());
        return "redirect:/home";
    }


}
