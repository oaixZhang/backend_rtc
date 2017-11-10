package com.rtc.bean;

public class SelectQuesBean extends BaseQuestionBean {
    public static int quesType = 2;

    private String optionA;
    private int flagA;
    private String optionB;
    private int flagB;
    private String optionC;
    private int flagC;
    private String optionD;
    private int flagD;

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public int getFlagA() {
        return flagA;
    }

    public void setFlagA(int flagA) {
        this.flagA = flagA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public int getFlagB() {
        return flagB;
    }

    public void setFlagB(int flagB) {
        this.flagB = flagB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public int getFlagC() {
        return flagC;
    }

    public void setFlagC(int flagC) {
        this.flagC = flagC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public int getFlagD() {
        return flagD;
    }

    public void setFlagD(int flagD) {
        this.flagD = flagD;
    }

    @Override
    public String toString() {
        return "SelectQuesBean{" +
                "optionA='" + optionA + '\'' +
                ", flagA=" + flagA +
                ", optionB='" + optionB + '\'' +
                ", flagB=" + flagB +
                ", optionC='" + optionC + '\'' +
                ", flagC=" + flagC +
                ", optionD='" + optionD + '\'' +
                ", flagD=" + flagD +
                ", quesId=" + quesId +
                ", content='" + content + '\'' +
                ", answer=" + answer +
                ", flag=" + flag +
                ", imagePath='" + imagePath + '\'' +
                ", accuracy=" + accuracy +
                ", sovleNum=" + sovleNum +
                ", symbols=" + symbols +
                '}';
    }
}
