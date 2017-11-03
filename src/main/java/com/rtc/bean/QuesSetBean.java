package com.rtc.bean;

import java.util.Set;

public class QuesSetBean {
    private int quesSetId;
    private int quesNum;
    private int teacherId;
    private int flag;
    private int mark;

    private Set<BaseQuestionBean> quesSet;

    public QuesSetBean() {
    }

    public int getQuesSetId() {
        return quesSetId;
    }

    public void setQuesSetId(int quesSetId) {
        this.quesSetId = quesSetId;
    }

    public int getQuesNum() {
        return quesNum;
    }

    public void setQuesNum(int quesNum) {
        this.quesNum = quesNum;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Set<BaseQuestionBean> getQuesSet() {
        return quesSet;
    }

    public void setQuesSet(Set<BaseQuestionBean> quesSet) {
        this.quesSet = quesSet;
    }
}
