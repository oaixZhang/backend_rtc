package com.rtc.service;

import com.rtc.bean.*;
import com.rtc.dao.QuestionMapper;
import com.rtc.utils.LogUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class QuestionServiceTest {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionService questionService;

    @Test
    public void getAllFillBlank() throws Exception {
        List<FillBlankBean> list = questionMapper.getAllFillBlankQuestions();
        System.out.println("fillBlankList=" + list.toString());
    }
    @Test
    public void getFillBlankById() throws Exception {
        FillBlankBean list = questionService.getFillBlankQuesById(1);
        System.out.println("fillBlank=" + list);
    }

    @Test
    public void getAllSelectQuestions() throws Exception {
        List<SelectQuesBean> list = questionMapper.getAllSelectQuestions();
        System.out.println("SelectQuesBean=" + list.toString());
    }

    @Test
    public void getAllMulitChoiceQues() throws Exception {
        List<MulitChoiceQuesBean> list = questionMapper.getAllMulitChoiceQues();
        System.out.println("fillBlankList=" + list.toString());
    }

    @Test
    public void getAllTrueOrFalseQues() throws Exception {
        List<TrueOrFalseQuesBean> list = questionMapper.getAllTrueOrFalseQues();
        System.out.println("fillBlankList=" + list.toString());
    }

    @Test
    public void getAllSimpleAnswerQues() throws Exception {
        List<SimpleAnswerQuesBean> list = questionMapper.getAllSimpleAnswerQues();
        System.out.println("fillBlankList=" + list.toString());
    }

    @Test
    public void createQuesSet() throws Exception {
        QuesSetBean quesSetBean = new QuesSetBean();

        HashSet<BaseQuestionBean> set = new HashSet<>();
        for (int i = 1; i < 4; i++) {
            BaseQuestionBean baseQuestionBean = new BaseQuestionBean();
            baseQuestionBean.setQuesId(1);
            baseQuestionBean.setQuesType(i);
            set.add(baseQuestionBean);
        }


        quesSetBean.setQuesNum(set.size());
        quesSetBean.setFlag(0);
        quesSetBean.setMark(100);
        quesSetBean.setTeacherId(1);
        quesSetBean.setQuesSet(set);

        if (questionMapper.createQuesSet(quesSetBean) == 1) {
            LogUtils.info("quesSetBean: quesSetId = " + quesSetBean.getQuesSetId());
            Iterator iterator = quesSetBean.getQuesSet().iterator();
            while (iterator.hasNext()) {
                if (questionMapper.insertQuesIntoSet(quesSetBean.getQuesSetId(),
                        (BaseQuestionBean) iterator.next()) == 1) {
                    LogUtils.info("insert success");
                } else {
                    LogUtils.info("error");
                }
            }
        }
    }

    @Test
    public void getQuesSetById() throws Exception {
        QuesSetBean quesSetBean = questionMapper.getQuesSetById(1);
        System.out.println("quesSetBean: " + quesSetBean);
    }

    @Test
    public void testGetQuesSetById() {
        QuesSetBean quesSetBean = questionService.getQuesSetById(1);
        System.out.println("quesSetBean: " + quesSetBean);

    }

}