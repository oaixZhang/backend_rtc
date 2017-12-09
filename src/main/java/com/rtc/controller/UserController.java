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

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllUsers() {
        return MyResponse.sResponse(userService.getAllUsers());
    }

    /**
     * 学生注册
     * @param userNmae 用户名
     * @param password 密码
     * @param name 姓名
     * @param grade 年龄
     * @param gender 性别
     */
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

    /**
     * 老师注册
     * @param phoneNum 手机号即用户账号
     * @param password 密码
     * @param name 姓名
     * @param school 学校
     * @param gender 性别
     */
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

    /**
     *学生登陆
     */
    @RequestMapping(value = "/stu/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> stuLogin(@RequestParam("userName") String userName,
                                     @RequestParam("password") String password) {
        return userService.login(userName, password);
    }

    /**
     * 教师登陆
     */
    @RequestMapping(value = "/teacher/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> teacherLogin(@RequestParam("phoneNum") String phoneNum,
                                     @RequestParam("password") String password) {
        return userService.login(phoneNum, password);
    }

    /**
     * 修改用户个人信息
     * @param stuId 学生Id
     * @param email
     * @param gender
     * @param school
     * @param grade
     * @param phoneNum
     * @param qqNum
     */
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
