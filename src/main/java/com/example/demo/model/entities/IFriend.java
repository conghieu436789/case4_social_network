package com.example.demo.model.entities;

import java.sql.Timestamp;

public interface IFriend {
    int getId();
    String getUsername();
    String getPhoto();
    String getAddress();
    Timestamp getDate_of_birth();
    String getFull_name();
    String getPhone();
    String getGender();
    Boolean getStatus();
}
