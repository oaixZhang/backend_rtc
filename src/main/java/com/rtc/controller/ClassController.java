package com.rtc.controller;

import com.rtc.bean.ClassBean;
import com.rtc.bean.MyResponse;
import com.rtc.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    /**
     * 教师创建班级
     *
     * @param teacherId   教师Id
     * @param classSize   班级人数
     * @param courseName  课程（班级）名称
     * @param courseHours 课程课时
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createClass(@RequestParam("teacherId") int teacherId,
                                           @RequestParam("classSize") int classSize,
                                           @RequestParam("courseName") String courseName,
                                           @RequestParam("courseHours") int courseHours) {
        ClassBean classBean = new ClassBean(classSize, courseHours, courseName);
        classBean.setTeacherId(teacherId);
        if (classService.createClass(classBean) == 1) {
            return MyResponse.sResponse(classBean);
        } else {
            return MyResponse.fResponse(400, "register failed", "");
        }
    }

    /**
     * 获取所有班级的列表
     *
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllClasses() {
        return MyResponse.sResponse(classService.getAllClasses());
    }

    /**
     * 获取老师创建的班级列表
     *
     * @param teacherId 教师Id
     * @return
     */
    @RequestMapping(value = "/teacherId/{teacherId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getClassesByTeacherId(@PathVariable int teacherId) {
        return MyResponse.sResponse(classService.getClassesByTeacherId(teacherId));
    }

    /**
     * 获取指定Id班级
     *
     * @param classId 班级Id
     * @return
     */
    @RequestMapping(value = "/classId/{classId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getClassByClassId(@PathVariable int classId) {
        return MyResponse.sResponse(classService.getClassByClassId(classId));
    }

    /**
     * 学生根据班级Id加入班级
     *
     * @param stuId   学生Id
     * @param classId 班级（课程）Id
     * @return
     */
    @RequestMapping(value = "/stu", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> stuJoinClass(@RequestParam("stuId") int stuId,
                                            @RequestParam("classId") int classId) {
        if (classService.stuJoinClass(stuId, classId) == 1) {
            return MyResponse.sResponse("join class succeed");
        } else {
            return MyResponse.fResponse(400, "join class failed", "");
        }
    }

    @RequestMapping(value = "/stuList/{classId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getStuListByClassId(@PathVariable int classId) {
        return MyResponse.sResponse(classService.getStuListByClassId(classId));
    }

}
