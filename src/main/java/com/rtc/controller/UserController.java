package com.rtc.controller;

import com.rtc.bean.MyResponse;
import com.rtc.bean.TeacherBean;
import com.rtc.bean.UserBean;
import com.rtc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllUsers() {
        return MyResponse.sResponse(userService.getAllUsers());
    }

    @RequestMapping(value = "/stu/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> stuRegister(@RequestParam("userName") String userNmae,
                                        @RequestParam("password") String password,
                                        @RequestParam("name") String name,
                                        @RequestParam("grade") String grade,
                                        @RequestParam("gender") int gender) {
        UserBean userBean = new UserBean(userNmae, password, name, grade, gender);
        if (userService.stuRegister(userBean) == 1) {
            return MyResponse.sResponse(userBean);
        } else {
            return MyResponse.fResponse(400, "register failed", "");
        }
    }

    @RequestMapping(value = "/teacher/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> teacherRegister(@RequestParam("phoneNum") String phoneNum,
                                        @RequestParam("password") String password,
                                        @RequestParam("name") String name,
                                        @RequestParam("school") String school,
                                        @RequestParam("gender") int gender) {
        TeacherBean teacherBean = new TeacherBean(password,name,school,phoneNum,gender);
        if (userService.teacherRegister(teacherBean) == 1) {
            return MyResponse.sResponse(teacherBean);
        } else {
            return MyResponse.fResponse(400, "register failed", "");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestParam("userName") String userName,
                                     @RequestParam("password") String password) {
        return userService.login(userName, password);
    }

    @RequestMapping(value = "/stu/info", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> updateStuInfo(@RequestParam("stuId") int stuId,
                                             @RequestParam("email") String email,
                                             @RequestParam("gender") int gender,
                                             @RequestParam("school") String school,
                                             @RequestParam("grade") String grade,
                                             @RequestParam("phoneNum") String phoneNum,
                                             @RequestParam("qqNum") String qqNum) {
        UserBean userBean = new UserBean();
        userBean.setStuId(stuId);
        userBean.setEmail(email);
        userBean.setGender(gender);
        userBean.setGrade(grade);
        userBean.setSchool(school);
        userBean.setPhoneNum(phoneNum);
        userBean.setQqNum(qqNum);
        return MyResponse.sResponse(userService.updateStuInfo(userBean));
    }
}
