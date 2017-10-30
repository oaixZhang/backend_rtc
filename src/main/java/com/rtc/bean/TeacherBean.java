package com.rtc.bean;

public class TeacherBean {
    private int teacherId;
    private String password;
    private String name;
    private String school;
    private String phoneNum;
    private int gender;

    public TeacherBean() {
    }

    public TeacherBean(String password, String name, String school, String phoneNum, int gender) {
        this.password = password;
        this.name = name;
        this.school = school;
        this.phoneNum = phoneNum;
        this.gender = gender;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
