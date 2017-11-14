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

}