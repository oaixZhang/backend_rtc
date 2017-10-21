package com.rtc.service;

import com.rtc.bean.UserBean;
import com.rtc.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void getAllUsers() throws Exception {
     List<UserBean> list=userMapper.getAllUsers();
        System.out.println("accountList=" + list.toString());
    }

}