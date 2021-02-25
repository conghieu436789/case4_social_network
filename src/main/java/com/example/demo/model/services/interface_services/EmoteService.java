package com.example.demo.model.services.interface_services;

import com.example.demo.model.entities.Emote;

public interface EmoteService extends CommonService<Emote>{
    void disLikePost(int user_id,int post_id);
    void disLikeComment(int id,int comment_id);
}
