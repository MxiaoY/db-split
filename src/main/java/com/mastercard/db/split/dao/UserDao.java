package com.mastercard.db.split.dao;

import com.mastercard.db.split.dto.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface UserDao extends Mapper<User> {

}
