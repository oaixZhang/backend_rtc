package com.rtc.service.impl;

import com.rtc.bean.ClassBean;
import com.rtc.bean.UserBean;
import com.rtc.dao.ClassMapper;
import com.rtc.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("classService")
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;

    @Override
    public List<ClassBean> getAllClasses() {
        return classMapper.getAllClasses();
    }

    @Override
    public List<ClassBean> getClassesByTeacherId(int teacherId) {
        return classMapper.getClassesByTeacherId(teacherId);
    }

    @Override
    public List<ClassBean> getClassByClassId(int classId) {
        return classMapper.getClassByClassId(classId);
    }

    @Override
    public int createClass(ClassBean classBean) {
        return classMapper.createClass(classBean);
    }

    @Override
    public int stuJoinClass(int stuId, int classId) {
        return classMapper.stuJoinClass(stuId, classId);
    }

    @Override
    public List<HashMap> getStuListByClassId(int classId) {
        List<HashMap> list = new ArrayList<>();
        for (UserBean user:classMapper.getStuListByClassId(classId)) {
            HashMap<String,Object> map = new HashMap<>();
            map.put("id",user.getId());
            map.put("name",user.getName());
            map.put("grade",user.getGrade());
            list.add(map);
        }
        return list;
    }

}
