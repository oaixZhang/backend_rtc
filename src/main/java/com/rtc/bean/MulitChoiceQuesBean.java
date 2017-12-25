package com.rtc.bean;

public class MulitChoiceQuesBean extends BaseQuestionBean {
    public static String type = "multiple";

    @Override
    public String toString() {
        return "MulitChoiceQuesBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", answer=" + answer +
                ", point=" + point +
                ", symbols=" + symbols +
                '}';
    }
}
