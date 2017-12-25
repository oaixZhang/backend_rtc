package com.rtc.bean;

import java.util.List;

public class ClassBean {
    private int id;
    private int teacherId;
    private int classSize;
    private int courseHours;
    private String courseName;

    private List<UserBean> stuList;

    public ClassBean() {
    }

    public ClassBean(int classSize, int courseHours, String courseName) {
        this.classSize = classSize;
        this.courseHours = courseHours;
        this.courseName = courseName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassSize() {
        return classSize;
    }

    public void setClassSize(int classSize) {
        this.classSize = classSize;
    }

    public int getCourseHours() {
        return courseHours;
    }

    public void setCourseHours(int courseHours) {
        this.courseHours = courseHours;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<UserBean> getStuList() {
        return stuList;
    }

    public void setStuList(List<UserBean> stuList) {
        this.stuList = stuList;
    }
}
