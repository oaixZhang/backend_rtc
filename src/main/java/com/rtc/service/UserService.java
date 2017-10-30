package com.rtc.service;

import com.rtc.bean.MyResponse;
import com.rtc.bean.TeacherBean;
import com.rtc.bean.UserBean;
import com.rtc.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Transactional
    public List<UserBean> getAllUsers(){
        return userMapper.getAllUsers();
    }

    public int stuRegister(UserBean userBean){
        return userMapper.stuRegister(userBean);
    }

    public int teacherRegister(TeacherBean teacherBean){
        return userMapper.teacherRegister(teacherBean);
    }


    public Map<String,Object> login(String userName, String password){
        UserBean userBean= userMapper.login(userName,password);
        if (password.equals(userBean.getPassword())){
            return MyResponse.sResponse(userBean);
        }else {
            return MyResponse.fResponse(400,"password error","");
        }

    }

    public UserBean updateStuInfo(UserBean userBean){
        return userMapper.updateStuInfo(userBean);
    }


    }
