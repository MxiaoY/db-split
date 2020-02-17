package com.mastercard.db.split.service.impl;

import com.mastercard.db.split.dao.UserDao;
import com.mastercard.db.split.dto.User;
import com.mastercard.db.split.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String userId) {
        log.info("从mysql中获取用户数据");
        User user = new User();
        user.setUserId(userId);
        return userDao.selectOne(user);
    }

    @Override
    public void updateUser(User user) {
        int i = userDao.updateByPrimaryKey(user);
    }

    @Override
    public void addUser() {
        User user = new User();
        String userId = UUID.randomUUID().toString().replaceAll("-", "");
        user.setUserId(userId);
        log.info("userId:【{}】",userId);
        user.setUsername("xiaoyu"+String.valueOf(new Random().nextInt(10)));
        userDao.insert(user);
    }

    @Override
    public void delUser(User user) {
        userDao.deleteByPrimaryKey(user);
    }


}
