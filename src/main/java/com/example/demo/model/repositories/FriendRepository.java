package com.example.demo.model.repositories;

import com.example.demo.model.entities.Friend;
import com.example.demo.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Integer> {

    @Query(value = "select * from social_network_module4.friend where user_receiver_id = ?1 and status = true ", nativeQuery = true)
    List<Friend> getAllFriendByUserId(int id);
}
