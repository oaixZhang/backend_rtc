package com.rtc.bean;

public class CompletionBean extends BaseQuestionBean{
    public static String type = "completion";

    @Override
    public String toString() {
        return "CompletionBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", answer=" + answer +
                ", point=" + point +
                ", symbols=" + symbols +
                '}';
    }
}
