package com.example.demo.model.repositories;

import com.example.demo.model.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
   List<Post> findAllByTitle (String title);
}
