package com.rtc.service;

import com.rtc.bean.UserBean;
import com.rtc.dao.UserMapper;
import com.rtc.utils.LogUtils;
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
    @Autowired
    private UserService userService;
    @Test
    public void getAllUsers() throws Exception {
     List<UserBean> list=userMapper.getAllUsers();
        System.out.println("accountList=" + list.toString());
    }
    @Test
    public void testStuRegister() throws Exception {
        UserBean userBean = new UserBean("Toom123", "123123"
                , "toom", "g-1", 1);

        userService.stuRegister(userBean);
        LogUtils.info("UseriD: "+userBean.getStuId());
    }

}