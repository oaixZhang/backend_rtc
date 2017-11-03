package com.rtc.service;

import com.rtc.bean.*;
import com.rtc.dao.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Iterator;
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

    @Transactional
    public QuesSetBean createQuesSet(QuesSetBean quesSetBean) {
//        QuesSetBean setBean = new QuesSetBean();

        HashSet<BaseQuestionBean> set = new HashSet<>();
        BaseQuestionBean baseQuestionBean1 = new BaseQuestionBean();
        baseQuestionBean1.setQuesId(1);
        baseQuestionBean1.setQuesType(BaseQuestionBean.FILLBLANK);
        set.add(baseQuestionBean1);
        BaseQuestionBean baseQuestionBean2 = new BaseQuestionBean();
        baseQuestionBean2.setQuesId(1);
        baseQuestionBean2.setQuesType(BaseQuestionBean.SELECT);
        set.add(baseQuestionBean2);

        quesSetBean.setQuesNum(2);
        quesSetBean.setFlag(0);
        quesSetBean.setMark(100);
        quesSetBean.setTeacherId(1);
        quesSetBean.setQuesSet(set);

        if (questionMapper.createQuesSet(quesSetBean)==1) {
            Iterator iterator = set.iterator();
            while (iterator.hasNext()){
                questionMapper.insertQuesIntoSet(quesSetBean.getQuesSetId(), (BaseQuestionBean) iterator.next());
            }
        }
        return quesSetBean;
    }

}
