package com.mastercard.db.split.controller;


import com.mastercard.db.split.api.UserInfoApi;
import com.mastercard.db.split.dto.User;
import com.mastercard.db.split.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController implements UserInfoApi {

      @Autowired
    private UserService userService;

    @Override
    public User getUser(String userId) {
        return userService.getUser(userId);
    }

    @Override
    public void updateUser(User user) {
        userService.updateUser(user);
    }

    @Override
    public void addUser() {
        userService.addUser();
    }

    @Override
    public void delUser(User user) {
        userService.delUser(user);
    }


}
