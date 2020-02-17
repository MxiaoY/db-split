package com.mastercard.db.split.service;


import com.mastercard.db.split.dto.User;

public interface UserService {

    User getUser(String userId);

    void updateUser(User user);

    void addUser();

    void delUser(User user);
}
