package com.example.demo.model.repositories;

import com.example.demo.model.entities.Comment;
import com.example.demo.model.entities.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
