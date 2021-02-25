package com.example.demo.controller.home;

import com.example.demo.model.entities.Comment;
import com.example.demo.model.entities.Post;
import com.example.demo.model.entities.User;
import com.example.demo.model.services.interface_services.CommentService;
import com.example.demo.model.services.interface_services.FriendService;
import com.example.demo.model.services.interface_services.PostService;
import com.example.demo.model.services.interface_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Controller
public class SecurityController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private FriendService friendService;

    @Autowired
    private CommentService commentService;

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
        User user = userService.findByUserName(getPrincipal()).get();
        model.addAttribute("userList",friendService.getListFriend(user.getId()));
        model.addAttribute("user", getPrincipal());
        List<Post> postList = postService.getAll();
        Collections.reverse(postList);
        for (Post post : postList) {
            post.setLike(checkLikedPost(user, post));
            for (int j = 0; j < post.getCommentList().size(); j++) {
                post.getCommentList().get(j).setLike(checkLikedComment(user, post.getCommentList().get(j)));
            }
        }


        model.addAttribute("posts",postList);
        model.addAttribute("nguoidung",user);
        return "hieu/home";
    }

    private boolean checkLikedPost(User user, Post p){
        for (int i = 0; i < p.getEmoteList().size(); i++) {
            if (p.getEmoteList().get(i).getUser().getId().equals(user.getId())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkLikedComment(User user, Comment p){
        for (int i = 0; i < p.getEmoteList().size(); i++) {
            if (p.getEmoteList().get(i).getUser().getId().equals(user.getId())) {
                return true;
            }
        }
        return false;
    }



    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @PostMapping("/createComment")
    public String createComment(Comment comment){
        comment.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        commentService.save(comment);
        return "redirect:/home";
    }

}
