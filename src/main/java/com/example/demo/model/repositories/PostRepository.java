package com.example.demo.model.repositories;

import com.example.demo.model.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    @Transactional
    @Modifying
    @Query(value = "delete from post where user_id = ?1",nativeQuery = true)
    void deleteAllPostByUID(int id);
}
