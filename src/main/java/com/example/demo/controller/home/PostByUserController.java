package com.example.demo.controller.home;

import com.example.demo.model.entities.Post;
import com.example.demo.model.entities.User;
import com.example.demo.model.services.interface_services.PostService;
import com.example.demo.model.services.interface_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostByUserController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "posting",method = RequestMethod.POST)
    public String createPost(Post post, @RequestParam(value = "usernameposting")String username){
        User user = userService.findByUserName(username).get();
        post.setUser(user);
        postService.save(post);

        return "redirect:/home";
    }

}
