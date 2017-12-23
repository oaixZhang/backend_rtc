package com.rtc.service;

import com.rtc.bean.TeacherBean;
import com.rtc.bean.UserBean;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<UserBean> getAllUsers();

    public int stuRegister(UserBean userBean);

    public int teacherRegister(TeacherBean teacherBean);

    public Map<String, Object> login(String userName, String password);

    public UserBean updateStuInfo(UserBean userBean);


}
