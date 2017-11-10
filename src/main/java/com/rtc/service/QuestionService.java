package com.rtc.service;

import com.rtc.bean.*;
import com.rtc.dao.QuestionMapper;
import com.rtc.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    @Transactional
    public QuesSetBean createQuesSet(QuesSetBean quesSetBean) {
        if (questionMapper.createQuesSet(quesSetBean) == 1) {
            LogUtils.info("quesSetBean: quesSetId = " + quesSetBean.getQuesSetId());
            Iterator iterator = quesSetBean.getQuesSet().iterator();
            while (iterator.hasNext()) {
                if (questionMapper.insertQuesIntoSet(quesSetBean.getQuesSetId(), (BaseQuestionBean) iterator.next()) == 1) {
                    LogUtils.info("insert success");
                } else {
                    LogUtils.info("error");
                }
            }
        }
        return quesSetBean;
    }

    public QuesSetBean getQuesSetById(int quesSetId) {
        QuesSetBean quesSetBean = questionMapper.getQuesSetById(quesSetId);
        Iterator iterator = quesSetBean.getQuesSet().iterator();
        Set<BaseQuestionBean> finalSet = new HashSet<>();

        while (iterator.hasNext()) {
            BaseQuestionBean baseQuestionBean = (BaseQuestionBean) iterator.next();
            switch (baseQuestionBean.getQuesType()) {
                case BaseQuestionBean.FILLBLANK:
                    finalSet.add(questionMapper.getFillBlankQuesById(baseQuestionBean.getQuesId()));
                    break;
                case BaseQuestionBean.SELECT:
                    finalSet.add(questionMapper.getSelectQuesById(baseQuestionBean.getQuesId()));
                    break;
                case BaseQuestionBean.MULITCHOICE:
                    finalSet.add(questionMapper.getMulitChoiceQuesById(baseQuestionBean.getQuesId()));
                    break;
                case BaseQuestionBean.SIMPLEANSWER:
                    finalSet.add(questionMapper.getSimpleAnswerQuesById(baseQuestionBean.getQuesId()));
                    break;
                case BaseQuestionBean.TRUEORFALSE:
                    finalSet.add(questionMapper.getTrueOrFalseQuesById(baseQuestionBean.getQuesId()));
                    break;
            }
        }

        quesSetBean.setQuesSet(finalSet);
        return quesSetBean;
    }
}
