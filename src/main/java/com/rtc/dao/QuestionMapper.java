package com.rtc.dao;

import com.rtc.bean.*;

import java.util.List;

public interface QuestionMapper {
    public List<FillBlankBean> getAllFillBlankQuestions();

    public List<SelectQuesBean> getAllSelectQuestions();

    public List<MulitChoiceQuesBean> getAllMulitChoiceQues();

    public List<SimpleAnswerQuesBean> getAllSimpleAnswerQues();

    public List<TrueOrFalseQuesBean> getAllTrueOrFalseQues();

    public FillBlankBean getFillBlankQuesById(int quesId);

    public SelectQuesBean getSelectQuesById(int quesId);

    public MulitChoiceQuesBean getMulitChoiceQuesById(int quesId);

    public SimpleAnswerQuesBean getSimpleAnswerQuesById(int quesId);

    public TrueOrFalseQuesBean getTrueOrFalseQuesById(int quesId);

}
