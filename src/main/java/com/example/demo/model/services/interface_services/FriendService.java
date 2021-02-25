package com.example.demo.model.services.interface_services;

import com.example.demo.model.entities.Friend;
import com.example.demo.model.entities.IFriend;

import java.util.List;

public interface FriendService extends CommonService<Friend>{
    List<IFriend> getListFriend(Integer id);
}
