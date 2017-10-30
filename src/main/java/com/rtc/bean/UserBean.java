package com.rtc.bean;

public class UserBean {
    private int stuID;
    private String email;
    private String password;
    private String userName;
    private String name;
    private String school;
    private String grade;
    private String qqNum;
    private String phoneNum;
    private int gender;

    public UserBean() {
    }

    public UserBean(String userName,String password,  String name, String grade, int gender) {
        this.password = password;
        this.userName = userName;
        this.name = name;
        this.grade = grade;
        this.gender = gender;
    }

    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
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

    @Override
    public String toString() {
        return "UserBean{" +
                "stuID='" + stuID + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", grade='" + grade + '\'' +
                ", qqNum='" + qqNum + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", gender=" + gender +
                '}';
    }
}
