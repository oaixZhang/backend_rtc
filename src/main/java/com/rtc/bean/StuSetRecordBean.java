package com.rtc.bean;

import java.util.Date;

public class StuSetRecordBean {
    private int stuId;
    private String name;
    private int quesSetId;
    private int classId;
    private int flag;
    private Date committedDate;
    private Date checkedDate;
    private float accuracy;

    public StuSetRecordBean() {
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getQuesSetId() {
        return quesSetId;
    }

    public void setQuesSetId(int quesSetId) {
        this.quesSetId = quesSetId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Date getCommittedDate() {
        return committedDate;
    }

    public void setCommittedDate(Date committedDate) {
        this.committedDate = committedDate;
    }

    public Date getCheckedDate() {
        return checkedDate;
    }

    public void setCheckedDate(Date checkedDate) {
        this.checkedDate = checkedDate;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }
}
