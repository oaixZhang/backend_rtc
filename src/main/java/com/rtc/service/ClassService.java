package com.rtc.service;

import com.rtc.bean.ClassBean;
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

    public int createClass(ClassBean classBean) {
        return classMapper.createClass(classBean);
    }

    public int stuJoinClass(int stuId, int classId) {
        return classMapper.stuJoinClass(stuId, classId);
    }
}
