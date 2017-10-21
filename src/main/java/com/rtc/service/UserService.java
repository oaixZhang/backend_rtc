package com.rtc.service;

import com.rtc.bean.UserBean;
import com.rtc.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Transactional
    public List<UserBean> getAllUsers(){
        return userMapper.getAllUsers();
    }

    }
