package com.rtc.dao;

import com.rtc.bean.TeacherBean;
import com.rtc.bean.UserBean;

import java.util.List;

public interface UserMapper {
    public List<UserBean> getAllUsers();

    public int stuRegister(UserBean userBean);

    public int teacherRegister(TeacherBean teacherBean);

    public UserBean login(String userName,String password);

    public UserBean updateStuInfo(UserBean userBean);




}
