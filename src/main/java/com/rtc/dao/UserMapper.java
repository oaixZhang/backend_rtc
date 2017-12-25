package com.rtc.dao;

import com.rtc.bean.TeacherBean;
import com.rtc.bean.UserBean;

import java.util.List;

public interface UserMapper {
    public List<UserBean> getAllUsers();

    public int register(UserBean userBean);

    public UserBean login(String phone,String password);

    public UserBean updateStuInfo(UserBean userBean);




}
