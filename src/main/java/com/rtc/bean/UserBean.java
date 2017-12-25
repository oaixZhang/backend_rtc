package com.rtc.bean;

public class UserBean {
    private int id;
    private String email;
    private String password;
    private String userName;
    private String name;
    private String school;
    private String grade;
    private String qq;
    private String phone;
    private int gender;
    private boolean isTeacher;

    public UserBean() {
    }

    public UserBean(String phone, String password, String name, String grade, int gender, boolean isTeacher) {
        this.password = password;
        this.phone = phone;
        this.name = name;
        this.grade = grade;
        this.gender = gender;
        this.isTeacher = isTeacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userId=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", grade='" + grade + '\'' +
                ", qqNum='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", isTeacher=" + isTeacher +
                '}';
    }
}
