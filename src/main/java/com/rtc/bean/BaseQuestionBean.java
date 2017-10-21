package com.rtc.bean;

public class BaseQuestionBean {
    private String quesNum;
    private String stuID;
    private String content;
    private String answer;
    private int flag;
    private String imagePath;
    private int problemSetNum;
    private int proProblemSetNum;
    private double accuracy;
    private int sovleNum;

    public String getQuesNum() {
        return quesNum;
    }

    public void setQuesNum(String quesNum) {
        this.quesNum = quesNum;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getProblemSetNum() {
        return problemSetNum;
    }

    public void setProblemSetNum(int problemSetNum) {
        this.problemSetNum = problemSetNum;
    }

    public int getProProblemSetNum() {
        return proProblemSetNum;
    }

    public void setProProblemSetNum(int proProblemSetNum) {
        this.proProblemSetNum = proProblemSetNum;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public int getSovleNum() {
        return sovleNum;
    }

    public void setSovleNum(int sovleNum) {
        this.sovleNum = sovleNum;
    }
}
