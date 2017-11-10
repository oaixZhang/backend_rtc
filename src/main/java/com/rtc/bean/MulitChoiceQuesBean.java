package com.rtc.bean;

public class MulitChoiceQuesBean extends BaseQuestionBean {
    public static int quesType = 3;

    @Override
    public String toString() {
        return "MulitChoiceQuesBean{" +
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
