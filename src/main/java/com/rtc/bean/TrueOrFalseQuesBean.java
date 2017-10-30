package com.rtc.bean;

public class TrueOrFalseQuesBean{
    private int quesId;
    private String content;
    private int answer;
    private int flag;
    private String imagePath;
    private double accuracy;
    private int sovleNum;

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
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
