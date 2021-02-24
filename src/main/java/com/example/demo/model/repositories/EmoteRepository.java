package com.example.demo.model.repositories;

import com.example.demo.model.entities.Emote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmoteRepository extends JpaRepository<Emote,Integer> {
}
