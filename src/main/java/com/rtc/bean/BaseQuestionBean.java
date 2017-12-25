package com.rtc.bean;

import java.util.HashSet;
import java.util.Set;

public class BaseQuestionBean {
    protected int id;
    protected String title;
    protected String imgUrl;
    protected Object answer;
    protected int point;
    private String type = "base";

    public static final String[] SYMBOLS = {"^", "_", "\\sin", "\\cos", "\\frac", "\\sqrt", "_"};

    protected Set<String> symbols;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        symbols = new HashSet<>();
        for (String str : SYMBOLS) {
            if (title.indexOf(str) != -1)
                symbols.add(str);
        }
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Object getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static String[] getSYMBOLS() {
        return SYMBOLS;
    }

    public Set<String> getSymbols() {
        return symbols;
    }

    public void setSymbols(Set<String> symbols) {
        this.symbols = symbols;
    }




}
