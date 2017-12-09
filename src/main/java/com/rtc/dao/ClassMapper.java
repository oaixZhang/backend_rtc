package com.rtc.dao;

import com.rtc.bean.ClassBean;
import com.rtc.bean.UserBean;

import java.util.List;

public interface ClassMapper {
    public List<ClassBean> getAllClasses();

    public List<ClassBean> getClassesByTeacherId(int teacherId);

    public List<ClassBean> getClassByClassId(int classId);

    public int createClass(ClassBean classBean);

    public int stuJoinClass(int stuId, int classId);

    public List<UserBean> getStuListByClassId(int classId);
}
