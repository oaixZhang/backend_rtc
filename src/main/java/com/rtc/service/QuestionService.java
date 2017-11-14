package com.rtc.service;

import com.rtc.bean.*;
import com.rtc.dao.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Transactional
    public List<FillBlankBean> getAllFillBlankQuestions() {
        return questionMapper.getAllFillBlankQuestions();
    }

    @Transactional
    public List<SelectQuesBean> getAllSelectQuestions() {
        return questionMapper.getAllSelectQuestions();
    }

    @Transactional
    public List<MulitChoiceQuesBean> getAllMulitChoiceQues() {
        return questionMapper.getAllMulitChoiceQues();
    }

    @Transactional
    public List<SimpleAnswerQuesBean> getAllSimpleAnswerQues() {
        return questionMapper.getAllSimpleAnswerQues();
    }

    @Transactional
    public List<TrueOrFalseQuesBean> getAllTrueOrFalseQues() {
        return questionMapper.getAllTrueOrFalseQues();
    }

    public FillBlankBean getFillBlankQuesById(int quesId) {
        return questionMapper.getFillBlankQuesById(quesId);
    }

    public SelectQuesBean getSelectQuesById(int quesId) {
        return questionMapper.getSelectQuesById(quesId);
    }

    public MulitChoiceQuesBean getMulitChoiceQuesById(int quesId) {
        return questionMapper.getMulitChoiceQuesById(quesId);
    }

    public SimpleAnswerQuesBean getSimpleAnswerQuesById(int quesId) {
        return questionMapper.getSimpleAnswerQuesById(quesId);
    }

    public TrueOrFalseQuesBean getTrueOrFalseQuesById(int quesId) {
        return questionMapper.getTrueOrFalseQuesById(quesId);
    }

}
