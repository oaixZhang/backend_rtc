package com.rtc.service.impl;

import com.rtc.bean.*;
import com.rtc.dao.QuestionMapper;
import com.rtc.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    @Transactional
    public List<CompletionBean> getAllCompletions() {
        return questionMapper.getAllCompletionQuestions();
    }

    @Override
    public List<SelectQuesBean> getAllSelectQuestions() {
        return questionMapper.getAllSelectQuestions();
    }

    @Override
    public List<MulitChoiceQuesBean> getAllMulitChoiceQues() {
        return questionMapper.getAllMulitChoiceQues();
    }

    @Override
    @Transactional
    public List<SimpleAnswerQuesBean> getAllSimpleAnswerQues() {
        return questionMapper.getAllSimpleAnswerQues();
    }

    @Override
    @Transactional
    public List<TrueOrFalseQuesBean> getAllTrueOrFalseQues() {
        return questionMapper.getAllTrueOrFalseQues();
    }

    @Override
    public CompletionBean getCompletionById(int quesId) {
        return questionMapper.getCompletionById(quesId);
    }

    @Override
    public SelectQuesBean getSelectQuesById(int quesId) {
        return questionMapper.getSelectQuesById(quesId);
    }

    @Override
    public MulitChoiceQuesBean getMulitChoiceQuesById(int quesId) {
        return questionMapper.getMulitChoiceQuesById(quesId);
    }

    @Override
    public SimpleAnswerQuesBean getSimpleAnswerQuesById(int quesId) {
        return questionMapper.getSimpleAnswerQuesById(quesId);
    }

    @Override
    public TrueOrFalseQuesBean getTrueOrFalseQuesById(int quesId) {
        return questionMapper.getTrueOrFalseQuesById(quesId);
    }

}
