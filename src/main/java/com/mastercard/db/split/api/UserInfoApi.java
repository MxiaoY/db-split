package com.mastercard.db.split.api;

import com.mastercard.db.split.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface UserInfoApi {

    @GetMapping(value = "getUser")
    public User getUser(String userId);

    @GetMapping(value = "updateUser")
    public void updateUser(User user);

    @GetMapping(value = "addUser")
    public void addUser();

    @GetMapping(value = "delUser")
    public void delUser(User user);

}
