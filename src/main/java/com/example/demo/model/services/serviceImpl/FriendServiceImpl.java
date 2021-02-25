package com.example.demo.model.services.serviceImpl;

import com.example.demo.model.entities.Friend;
import com.example.demo.model.entities.IFriend;
import com.example.demo.model.repositories.FriendRepository;
import com.example.demo.model.services.interface_services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendRepository friendRepository;
    @Override
    public List<Friend> getAll() {
        return friendRepository.findAll();
    }

    @Override
    public Optional<Friend> findById(int id) {
        return friendRepository.findById(id);
    }

    @Override
    public Friend save(Friend friend) {
        return friendRepository.save(friend);
    }

    @Override
    public void delete(int id) {
        friendRepository.deleteById(id);
    }

    @Override
    public List<IFriend> getListFriend(Integer id) {
        return friendRepository.getListFriend(id);
    }
}
