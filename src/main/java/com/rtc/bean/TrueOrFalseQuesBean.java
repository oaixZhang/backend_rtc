package com.rtc.bean;

public class TrueOrFalseQuesBean extends BaseQuestionBean{
    public static int quesType = 5;

    @Override
    public String toString() {
        return "TrueOrFalseQuesBean{" +
                "quesId=" + quesId +
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
