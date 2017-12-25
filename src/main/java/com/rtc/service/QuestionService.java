package com.rtc.service;


import com.rtc.bean.*;

import java.util.List;

public interface QuestionService {
    public List<CompletionBean> getAllCompletions();

    public List<SelectQuesBean> getAllSelectQuestions();

    public List<MulitChoiceQuesBean> getAllMulitChoiceQues();

    public List<SimpleAnswerQuesBean> getAllSimpleAnswerQues();

    public List<TrueOrFalseQuesBean> getAllTrueOrFalseQues();

    public CompletionBean getCompletionById(int quesId);

    public SelectQuesBean getSelectQuesById(int quesId);

    public MulitChoiceQuesBean getMulitChoiceQuesById(int quesId);

    public SimpleAnswerQuesBean getSimpleAnswerQuesById(int quesId);

    public TrueOrFalseQuesBean getTrueOrFalseQuesById(int quesId);

}
