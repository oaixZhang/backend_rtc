package com.rtc.bean;

public class SimpleAnswerQuesBean extends BaseQuestionBean {
    public static int quesType = 4;

    @Override
    public String toString() {
        return "SimpleAnswerQuesBean{" +
                "quesId=" + quesId +
                "quesType=" + quesType +
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
