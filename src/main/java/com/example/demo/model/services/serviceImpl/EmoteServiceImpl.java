package com.example.demo.model.services.serviceImpl;

import com.example.demo.model.entities.Emote;
import com.example.demo.model.repositories.EmoteRepository;
import com.example.demo.model.services.interface_services.EmoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmoteServiceImpl implements EmoteService {
    @Autowired
    private EmoteRepository emoteRepository;
    @Override
    public List<Emote> getAll() {
        return emoteRepository.findAll();
    }

    @Override
    public Optional<Emote> findById(int id) {
        return emoteRepository.findById(id);
    }

    @Override
    public Emote save(Emote emote) {
        return emoteRepository.save(emote);
    }

    @Override
    public void delete(int id) {
        emoteRepository.deleteById(id);
    }


    @Override
    public void disLikePost(int user_id, int post_id) {
        emoteRepository.disLikePost(user_id,post_id);
    }

    @Override
    public void disLikeComment(int id, int comment_id) {
        emoteRepository.disLikeComment(id,comment_id);
    }
}
