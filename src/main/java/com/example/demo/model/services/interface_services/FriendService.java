package com.example.demo.model.services.interface_services;

import com.example.demo.model.entities.Friend;

import java.util.List;
import java.util.Optional;

public interface FriendService extends CommonService<Friend>{
    List<Friend> findAllFriend(int receoverId);
}
