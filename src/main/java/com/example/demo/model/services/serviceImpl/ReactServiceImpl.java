package com.example.demo.model.services.serviceImpl;

import com.example.demo.model.entities.React;
import com.example.demo.model.repositories.ReactRepository;
import com.example.demo.model.services.interface_services.ReactService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReactServiceImpl implements ReactService {
    @Autowired
    private ReactRepository reactRepository;
    @Override
    public List<React> getAll() {
        return reactRepository.findAll();
    }

    @Override
    public Optional<React> findById(int id) {
        return reactRepository.findById(id);
    }

    @Override
    public React save(React react) {
        return reactRepository.save(react);
    }

    @Override
    public void delete(int id) {
        reactRepository.deleteById(id);
    }
}
