package com.example.demo.model.repositories;

import com.example.demo.model.entities.Friend;
import com.example.demo.model.entities.IFriend;
import com.example.demo.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Integer> {

    @Query(value = "SELECT distinct social_network_module4.user.id," +
            "social_network_module4.user.photo," +
            "social_network_module4.user.username," +
            "social_network_module4.user.address," +
            "social_network_module4.user.date_of_birth," +
            "social_network_module4.user.full_name," +
            "social_network_module4.user.phone," +
            "social_network_module4.user.gender," +
            "social_network_module4.friend.status\n" +
            "FROM social_network_module4.user\n" +
            "INNER JOIN social_network_module4.friend\n" +
            "ON social_network_module4.user.id = social_network_module4.friend.user_sender_id or social_network_module4.user.id = social_network_module4.friend.user_receiver_id where social_network_module4.friend.status = true and (social_network_module4.friend.user_sender_id =?1 or social_network_module4.friend.user_receiver_id =?1) and social_network_module4.user.id <> ?1 ",nativeQuery = true )
    List<IFriend> getListFriend(Integer id);
}
