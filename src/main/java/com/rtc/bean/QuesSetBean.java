package com.rtc.bean;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class QuesSetBean {
    private int quesSetId;
    private int quesNum;
    private int teacherId;
    private int flag;
    private int mark;

    private Date date;

    private List<BaseQuestionBean> quesList;

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

    public List<BaseQuestionBean> getQuesList() {
        return quesList;
    }

    public void setQuesList(List<BaseQuestionBean> quesSet) {
        this.quesList = quesSet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "QuesSetBean{" +
                "quesSetId=" + quesSetId +
                ", quesNum=" + quesNum +
                ", teacherId=" + teacherId +
                ", flag=" + flag +
                ", mark=" + mark +
                ", date=" + date +
                ", quesSet=" + quesList +
                '}';
    }
}
