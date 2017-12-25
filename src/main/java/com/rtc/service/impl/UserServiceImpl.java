package com.rtc.service.impl;

import com.rtc.bean.MyResponse;
import com.rtc.bean.UserBean;
import com.rtc.dao.UserMapper;
import com.rtc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserBean> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    @Transactional
    public int register(UserBean userBean) {
        return userMapper.register(userBean);
    }

    @Override
    public Map<String, Object> login(String phone, String password) {
        UserBean userBean = userMapper.login(phone, password);
        if (password.equals(userBean.getPassword())) {
            return MyResponse.sResponse(userBean);
        } else {
            return MyResponse.fResponse(400, "password error", "");
        }
    }

    @Override
    public UserBean updateStuInfo(UserBean userBean) {
        return userMapper.updateStuInfo(userBean);
    }


}
