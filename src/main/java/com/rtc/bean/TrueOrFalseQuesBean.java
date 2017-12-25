package com.rtc.bean;

public class TrueOrFalseQuesBean extends BaseQuestionBean{
    public static String type = "true or false";

    @Override
    public String toString() {
        return "TrueOrFalseQuesBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", answer=" + answer +
                ", point=" + point +
                ", symbols=" + symbols +
                '}';
    }
}
