package com.rtc.bean;

import java.util.HashSet;
import java.util.Set;

public class BaseQuestionBean {
    protected int quesId;
    protected String content;
    protected Object answer;
    protected int flag;
    protected String imagePath;
    protected double accuracy;
    protected int sovleNum;
    private int quesType;

    public static final String[] SYMBOLS = {"^", "_", "\\sin", "\\cos", "\\frac", "\\sqrt", "_"};

    public static final int FILLBLANK = 1;
    public static final int SELECT = 2;
    public static final int MULITCHOICE = 3;
    public static final int SIMPLEANSWER = 4;
    public static final int TRUEORFALSE = 5;


    protected Set<String> symbols;

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
        symbols = new HashSet<>();
        for (String str : SYMBOLS) {
            if (content.indexOf(str) != -1)
                symbols.add(str);
        }
        this.content = content;
    }

    public Object getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
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

    public Set<String> getSymbols() {
        return symbols;
    }

    public void setSymbols(Set<String> symbols) {
        this.symbols = symbols;
    }

    public int getQuesType() {
        return quesType;
    }

    public void setQuesType(int quesType) {
        this.quesType = quesType;
    }

    @Override
    public String toString() {
        return "BaseQuestionBean{" +
                "quesId='" + quesId + '\'' +
                ", content='" + content + '\'' +
                ", answer='" + answer + '\'' +
                ", flag=" + flag +
                ", imagePath='" + imagePath + '\'' +
                ", accuracy=" + accuracy +
                ", sovleNum=" + sovleNum +
                '}';
    }
}
