package com.example.demo.model.repositories;

import com.example.demo.model.entities.Emote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmoteRepository extends JpaRepository<Emote,Integer> {

    @Transactional
    @Modifying
    @Query(value = "delete from emote where user_id = ?1 and post_id = ?2",nativeQuery = true)
    void disLikePost(int user_id,int post_id);

    @Transactional
    @Modifying
    @Query(value = "delete from emote where user_id = ?1 and comment_id = ?2",nativeQuery = true)
    void disLikeComment(int user_id,int comment_id);
}
