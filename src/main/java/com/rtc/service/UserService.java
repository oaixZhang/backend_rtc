package com.rtc.service;

import com.rtc.bean.UserBean;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<UserBean> getAllUsers();

    public int register(UserBean userBean);

    public Map<String, Object> login(String phone, String password);

    public UserBean updateStuInfo(UserBean userBean);

}
