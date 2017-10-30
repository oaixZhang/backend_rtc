package com.rtc.dao;

import com.rtc.bean.ClassBean;

import java.util.List;

public interface ClassMapper {
    public List<ClassBean> getAllClasses();
    public int createClass(ClassBean classBean);
    public int stuJoinClass(int stuId,int classId);
}
