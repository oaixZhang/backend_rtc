package com.rtc.bean;

public class StuQuesRecordBean {
    public static final int NOTPROCESSED = 0;
    public static final int CORRECT = 1;
    public static final int WRONG = 2;
    private int id;
    private int stuId;
    private int quesId;
    private int quesSetId;
    private int quesType;
    private int flag;
    private String stuAnswer;

    public StuQuesRecordBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public int getQuesSetId() {
        return quesSetId;
    }

    public void setQuesSetId(int quesSetId) {
        this.quesSetId = quesSetId;
    }

    public int getQuesType() {
        return quesType;
    }

    public void setQuesType(int quesType) {
        this.quesType = quesType;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getStuAnswer() {
        return stuAnswer;
    }

    public void setStuAnswer(String stuAnswer) {
        this.stuAnswer = stuAnswer;
    }

    @Override
    public String toString() {
        return "StuQuesRecordBean{" +
                "id=" + id +
                ", stuId=" + stuId +
                ", quesId=" + quesId +
                ", quesSetId=" + quesSetId +
                ", quesType=" + quesType +
                ", flag=" + flag +
                ", stuAnswer='" + stuAnswer + '\'' +
                '}';
    }
}
