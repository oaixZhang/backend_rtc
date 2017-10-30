package com.rtc.controller;

import com.rtc.bean.ClassBean;
import com.rtc.bean.MyResponse;
import com.rtc.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createClass(@RequestParam("teacherId") int teacherId,
                                           @RequestParam("classSize") int classSize,
                                           @RequestParam("courseName") int courseName,
                                           @RequestParam("courseHours") int courseHours) {
        ClassBean classBean = new ClassBean(classSize, courseHours, courseName);
        classBean.setTeacherId(teacherId);
        if (classService.createClass(classBean) == 1) {
            return MyResponse.sResponse(classBean);
        } else {
            return MyResponse.fResponse(400, "register failed", "");
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllClasses() {
        return MyResponse.sResponse(classService.getAllClasses());
    }

    @RequestMapping(value = "/stu", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> stuJoinClass(@RequestParam("stuId") int stuId,
                                            @RequestParam("classId") int classId) {
        if (classService.stuJoinClass(stuId,classId)==1) {
            return MyResponse.sResponse("join class succeed");
        } else {
            return MyResponse.fResponse(400, "join class failed", "");
        }
    }
}
