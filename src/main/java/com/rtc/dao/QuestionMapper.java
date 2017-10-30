package com.rtc.dao;

import com.rtc.bean.*;

import java.util.List;

public interface QuestionMapper {
    public List<FillBlankBean> getAllFillBlankQuestions();
    public List<SelectQuesBean> getAllSelectQuestions();
    public List<MulitChoiceQuesBean> getAllMulitChoiceQues();
    public List<SimpleAnswerQuesBean> getAllSimpleAnswerQues();
    public List<TrueOrFalseQuesBean> getAllTrueOrFalseQues();

}
