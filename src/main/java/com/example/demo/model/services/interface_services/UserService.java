package com.example.demo.model.services.interface_services;

import com.example.demo.model.entities.User;

import java.util.Optional;

public interface UserService extends CommonService<User>{
    Optional<User> findByUserName(String username);
}
