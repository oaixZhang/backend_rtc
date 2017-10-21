package com.rtc.controller;

import com.rtc.bean.MyResponse;
import com.rtc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/users")
    @ResponseBody
    public Map<String, Object> getAllUsers(){
        return MyResponse.sResponse(userService.getAllUsers());
    }
}
