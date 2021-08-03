package com.zhenjiehan.community.service;

import com.zhenjiehan.community.dao.UserMapper;
import com.zhenjiehan.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }
}
