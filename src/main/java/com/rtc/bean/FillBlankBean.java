package com.rtc.bean;

public class FillBlankBean extends BaseQuestionBean{
    public static int quesType = 1;

    @Override
    public String toString() {
        return "FillBlankBean{" +
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
