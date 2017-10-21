package com.rtc.dao;

import com.rtc.bean.FillBlankBean;
import com.rtc.bean.SelectQuesBean;

import java.util.List;

public interface QuestionMapper {
    public List<FillBlankBean> getAllFillBlankQuestions();
    public List<SelectQuesBean> getAllSelectQuestions();

}
