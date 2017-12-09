package com.rtc.service;

import com.rtc.bean.ClassBean;
import com.rtc.bean.UserBean;
import com.rtc.dao.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassMapper classMapper;

    public List<ClassBean> getAllClasses() {
        return classMapper.getAllClasses();
    }

    public List<ClassBean> getClassesByTeacherId(int teacherId) {
        return classMapper.getClassesByTeacherId(teacherId);
    }

    public List<ClassBean> getClassByClassId(int classId) {
        return classMapper.getClassByClassId(classId);
    }

    public int createClass(ClassBean classBean) {
        return classMapper.createClass(classBean);
    }

    public int stuJoinClass(int stuId, int classId) {
        return classMapper.stuJoinClass(stuId, classId);
    }

    public List<UserBean> getStuListByClassId(int classId) {
        return classMapper.getStuListByClassId(classId);
    }
}
