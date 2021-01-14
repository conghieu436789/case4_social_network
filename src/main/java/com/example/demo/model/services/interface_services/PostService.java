package com.example.demo.model.services.interface_services;

import com.example.demo.model.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostService extends CommonService<Post>{
    List<Post> findAllByTitle(String title);
}
