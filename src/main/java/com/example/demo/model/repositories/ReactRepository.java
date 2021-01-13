package com.example.demo.model.repositories;

import com.example.demo.model.entities.React;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactRepository extends JpaRepository<React,Integer> {
}
