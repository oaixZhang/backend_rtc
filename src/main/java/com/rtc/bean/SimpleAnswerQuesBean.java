package com.rtc.bean;

public class SimpleAnswerQuesBean extends BaseQuestionBean {
    public static String type = "simple answer";

    @Override
    public String toString() {
        return "SimpleAnswerQuesBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", answer=" + answer +
                ", point=" + point +
                ", symbols=" + symbols +
                '}';
    }
}
